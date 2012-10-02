# A few things to note about Ruby specifically.

# 1) Methods need not be called with parentheses unless calls are nested.
# i.e. puts "hello, world"
# and puts("hello, world")
# But if you're going to nest them such as `parse do_something "data"`, then you need to do `parse(do_something "data")`

# 2) Returns can be stated implicitly, like so:
# def method
#   "Hello, world"
# end

# And about this code specifically.

# 1) It can probably be more generalized.
#    1) With more segmentation, too
# 2) I purposefully avoided Java-style programming.
#    1) No classes, but definitely segmented into functions
# 3) It's severely limited.
#    1) Everything is stored in memory with no automatic db dumps to disk.
#       1) You can dump with the dump command, and load with the load command
#       2) Dumps on Interrupt (^C)
#    2) Does not follow DNS protocol in any way. Has no authentication or anything.

# Commands:
# 1) where
#    Takes one argument: domain name.
#    where hypeno.de
# 2) add
#    Takes two arguments: domain name and IP address
#    add google.com 10.0.1.4
# 3) remove
#    Takes one argument: domain name
#    remove google.com
# 4) list
#    Takes no arguments, and just lists the records.
# 5) dump
#    Takes one argument: file name.
#    dump the_dump.yml
# 6) load
#    Takes one argument: file name.
#    load the_dump.yml

require 'socket'
require 'yaml'

$hash = {
  "hypeno.de" => "10.0.1.1"
}
$default = "dump.yml"

# function table
$actions = {
  "where" => Proc.new {|host|
    if $hash.include? host
      [$hash[host], nil]
    else
      [nil, "ERROR not found"]
    end
  },

  "add" => Proc.new {|host, ip|
    unless $hash.include? host
      [$hash[host] = ip, nil]
    else
      [nil, "ERROR already exists"]
    end
  },

  "remove" => Proc.new {|host|
    if $hash.include? host
      [$hash.delete(host), nil]
    else
      [nil, "ERROR no such record"]
    end
  },

  "list" => Proc.new {
    [$hash.inspect, nil]
  },

  "dump" => Proc.new {|filename|
    filename ||= $default
    begin
      File.open(filename, "w+") do |file|
        file.write $hash.to_yaml
      end
      ["SUCCESS", nil]
    rescue
      [nil, "SOME ERROR might not be writable"]
    end
  },

  "load" => Proc.new {|filename|
    filename ||= $default
    if not File.exists? filename
      [nil, "ERROR not found"]
    else
      $hash = YAML::load_file file
      ["SUCCESS", nil]
    end
  }
}

# split on spaces, first word is action, remaining are arguments
def parse(request)
  split = request.split
  obj = {
    :action => split[0].downcase,
    :args   => split[1..-1]
  }
  if obj[:args] == nil
    obj[:args] = []
  else
    obj[:args].delete(nil)
    obj[:args].each {|arg|
      arg = arg.downcase
    }
  end
  return obj
end

def do_with(data)
  # if we know the function
  if $actions.include? data[:action]
    begin
      # call the function with the arguments, and unpack the return into response and error
      data[:response], data[:error] = $actions[data[:action]].call *data[:args]
      if data[:error]
        data[:response] = data[:error]
      end
      
      # if too many or too few params
    rescue TypeError
      data[:response] = "ERROR bad params"
    end
  else
    data[:response] = "ERROR unknown action"
  end
  return data
end

server = TCPServer.open(4444)

loop {
  begin
    Thread.start(server.accept) do |client|
      # client info
      port, ip = Socket.unpack_sockaddr_in(client.getpeername)
      puts "LOG #{ip}:#{port}"

      # receive, parse, then act on it
      data = do_with(parse(client.recvfrom(1024)[0]))

      puts "LOG "+data.inspect

      # send client a response
      client.puts data[:response]
      # close connection
      client.close
    end

  rescue Interrupt
    puts
    $actions["dump"].call $default
    exit 0
  end
}
