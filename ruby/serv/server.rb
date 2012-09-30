# A few things to note about Ruby specifically.

# 1) Methods need not be called with parentheses unless calls are nested.
# i.e. puts "hello, world"
# and puts("hello, world")
# But if you're going to nest them such as parse do_something "data", then you need to do: parse(do_something "data")

# 2) Returns can be stated implicitly, like so:
# def method
#   "Hello, world"
# end

# And about this code specifically.

# 1) It can probably be more generalized.
# 2) I purposefully avoided Java-style programming.
# 3) It's severely limited.

require 'socket'

$hash = {
  "hypeno.de" => "10.0.1.1"
}

actions = {
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

server = TCPServer.open(4444)

loop {
  begin
    Thread.start(server.accept) do |client|
      # client info
      port, ip = Socket.unpack_sockaddr_in(client.getpeername)
      puts "#{ip}:#{port}"
      data = client.recvfrom(1024)
      data = parse(data[0])
      # if we know the function
      if actions.include? data[:action]
        begin
          # call the function with the arguments, and unpack the return into response and error
          data[:response], data[:error] = actions[data[:action]].call *data[:args]
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
      puts data.inspect
      client.puts data[:response]
      client.close
    end
  rescue Interrupt
    puts
    puts $hash.inspect
    exit 0
  end
}
