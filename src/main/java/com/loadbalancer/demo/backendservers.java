package com.loadbalancer.demo;

import java.util.ArrayList;
import java.util.List;

public class backendservers {
	
	
	private static List<String> servers= new ArrayList();
	private static int count=0;
	
	static {
		
		servers.add("IP1");
		servers.add("IP2");
		
		
	}
	
	
	public static String gethost()
	{
		String host = servers.get(count%servers.size());
		count++;
		return host;
		
		
		
	}
	

}
