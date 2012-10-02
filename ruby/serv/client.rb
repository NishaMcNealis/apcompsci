require 'socket'
require 'readline'

begin
  loop {
    begin
      socket = TCPSocket.new ARGV[0], ARGV[1]
    rescue Errno::ECONNREFUSED
      puts "ERROR server offline"
      exit 1
    end
    socket.puts Readline.readline("> ", true)
    puts socket.gets
    socket.close
  }
rescue Interrupt
  puts
  exit 0
end
