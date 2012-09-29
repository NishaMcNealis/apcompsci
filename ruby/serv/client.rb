require 'socket'
require 'readline'

loop {
  socket = TCPSocket.new ARGV[0], ARGV[1]
  socket.print Readline.readline("> ", true)
  puts socket.gets
}
