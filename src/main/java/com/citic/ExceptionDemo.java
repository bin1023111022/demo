package com.citic;

public class ExceptionDemo {
	
	public static void main(String[] args) {
	try{
		test();
	}catch(OneSelfDefineException e){
		System.out.println(e.getErrorCode()+"--"+e.getMassage());
	}
		System.out.println("-----------2-------------");
	}
	public static void test(){
		System.out.println("-----------1-------------");
		throw new OneSelfDefineException(LuoErrorCode.NULL_OBJ.getValue(),LuoErrorCode.NULL_OBJ.getDesc(),new Exception());
	}
}
