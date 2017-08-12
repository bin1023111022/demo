package com.citic;

public class MainTest {
	
	public static void main(String[] args) {
		String str = "1234567890";
		System.out.println(str.substring(2,8));
	}
public static void main2(String[] args) {
	String amt = "10";
	if(amt!=null&&amt.length()>0){
		if(amt.indexOf(".")>0){
			String t = amt.substring(amt.indexOf("."));
			if(t.length()>3){
				amt = amt.substring(0,amt.indexOf(".")+3).replace(".", "");
				
			}else if(t.length()==3){
				amt = amt.replace(".", "");
				
			}else if(t.length()==2){
				amt = amt.replace(".", "")+"0";
			}else{
				amt = amt.replace(".", "")+"00";
			}
		}else{
			amt = amt+"00";
		}
		System.out.println(amt);
		amt = amt.substring(0,amt.length()-2)+"."+amt.substring(amt.length()-2);
		System.out.println(amt);
	}
}
}
