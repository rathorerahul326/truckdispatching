package com.truckdispature.dto;

import java.util.Map;
import java.util.TreeMap;

public class Main {

	
	
	public static void main(String[] args) {
		
		Map<Integer, String	> map= new TreeMap<Integer	, String>();
		
	
	
		for(Map.Entry<Integer, String> l: map.entrySet())
		{
			
			System.out.println(l.getValue()+" "+ l.getKey());
		}
		
	}
	
}
