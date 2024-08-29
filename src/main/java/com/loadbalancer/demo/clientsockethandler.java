package com.loadbalancer.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class clientsockethandler implements Runnable {
	
	
	private Socket clientsockett;
	
	
	public clientsockethandler(final Socket socket1)
	{
		
		this.clientsockett=socket1;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	
			
			while(true)
			{
				try {
				
		
					InputStream clienttolb = clientsockett.getInputStream();
				
			
				
			
					OutputStream lbtoclient = clientsockett.getOutputStream();
				
				
				String hosts = backendservers.gethost();
				
			
		
				Socket ss2 = new Socket(hosts,8081);
			
			
		
			
			InputStream backendtolb = ss2.getInputStream();
			
		
			
			OutputStream lbtobackend = ss2.getOutputStream();
			
				
				
				
		
			
			Thread oneway = new Thread(){
				
				
				public void run() {
				
				
					
					
					int data;
					try {
						while(clienttolb.read()!=-1)
						{
							data=clienttolb.read();
						
							lbtobackend.write(data);
							
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
					
				
				
				
				
				
				
				
				
			}};
			
			oneway.start();
			
			

			Thread twoway = new Thread(){
				
				
				public void run() {
				
				
					
					
					int data;
					try {
						while(backendtolb.read()!=-1)
						{
							data=backendtolb.read();
						
							lbtoclient.write(data);
							
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
					
				
				
				
				
				
				
				
				
			};
			twoway.start();
			
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
			} 
			
	}
}

			
			
			
		
	
				
		
	
		
	


