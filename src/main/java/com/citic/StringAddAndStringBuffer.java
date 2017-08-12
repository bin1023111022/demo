package com.citic;

public class StringAddAndStringBuffer {

	
	public static void main(String[] args) {
		
		String st = "st";
		long bg = System.currentTimeMillis();
		for(int i =0;i<10000;i++){
			st = st+(i);
		}
		long en = System.currentTimeMillis();
		System.out.println(st);
		System.out.println(en-bg);
		
		StringBuffer sfb = new StringBuffer();
		sfb.append("st");
		long bg1 = System.currentTimeMillis();
		for(int i =0;i<10000;i++){
			sfb.append(i);
		}
		long en1 = System.currentTimeMillis();
		System.out.println(sfb.toString());
		System.out.println(en1-bg1);
	}
	
}
