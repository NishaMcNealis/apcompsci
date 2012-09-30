require 'socket'
require 'readline'

begin
  loop {
    socket = TCPSocket.new ARGV[0], ARGV[1]
    socket.puts Readline.readline("> ", true)
    puts socket.gets
    socket.close
  }
rescue Interrupt
  puts
  exit 0
end
