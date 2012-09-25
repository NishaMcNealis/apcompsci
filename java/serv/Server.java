import java.lang.*;
import java.io.*;
import java.net.*;

class Server {
    public static ServerSocket server;
    public static Socket socket;
    public static PrintWriter out;
    public static String data;

    public static void main(String args[]) {
	init();
	while (true) {
	    try {
		opensocket();
		senddata(data);
		closesocket();
	    }
	    catch (Exception e) {
		break;
	    }
	}
	end();
    }

    public static void init() {
	try {
	    server = new ServerSocket(4444);
	    data = "Hello, world!";
	}
	catch (Exception e) {
	    end();
	}
    }   

    public static void printmsg(String msg) {
	System.out.println(msg);
    }

    public static void opensocket() {
	try {
	socket = server.accept();
	printmsg("Client has connected.");
       	out = new PrintWriter(socket.getOutputStream(), true);
	}
	catch (Exception e) {
	    end();
	}
    }

    public static void senddata(String msg) {
	out.print(msg);
	printmsg("Sending: " + msg);
    }

    public static void closesocket() {
	try {
	    out.close();
	    socket.close();
	    printmsg("Closing socket.");
	}
	catch (Exception e) {
	    end();
	}
    }

    public static void end() {
	try {
	    server.close();
	}
	catch (Exception e) {
	    System.exit(1);
	}
    }
}