require 'socket'

actions = {
  "file" => Proc.new { |filename|
    File.read(filename)
  }
}

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
  client = server.accept
  data = client.recvfrom(1024)
  data = parse(data[0])
  if actions.include? data[:action]
    begin
      response = actions[data[:action]].call *data[:args]
    rescue TypeError
      response = "ERROR bad params"
    end
  else
    response = "ERROR unknown action"
  end
  client.puts response
  client.close
}
