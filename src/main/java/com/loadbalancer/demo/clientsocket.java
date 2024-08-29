package com.loadbalancer.demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class clientsocket {
	
	
	
	
	public static void main(String args[]) throws IOException
	{
		ServerSocket server = new ServerSocket(8080);
		Socket socket;
		
		while(true)
		{
			socket = server.accept();
			System.out.println("The request comes from the ip" + socket.toString());
			sockethandle(socket);
			
		}
		
		
	}
	
	public static void sockethandle(final Socket socketr)
	{
		
		
		clientsockethandler cst = new clientsockethandler(socketr);
		Thread clientsocketthread = new Thread(cst);
		clientsocketthread.start();
	}
	
	
	

}
