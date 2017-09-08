package com.citic;

public class ReturnTest {
	
	public static int run(){
		int[] li = new int[]{1,2,3,4,5,6,7};
		for(int lc : li){
			if(lc == 3){
				return lc;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(ReturnTest.run());
	}
}
