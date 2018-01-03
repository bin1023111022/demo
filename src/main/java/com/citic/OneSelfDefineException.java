package com.citic;

public class OneSelfDefineException extends RuntimeException {
		
	private String errorCode;
	private String massage;
	private Exception e;
	
	/**
	 * 
	 * @param errorCode : 异常码
	 * @param massage : 自定义异常信息
	 * @param e : 原始异常
	 */
	public OneSelfDefineException(String errorCode,String massage,Exception e){
		this.errorCode = errorCode;
		this.massage = massage;
		this.e = e;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	public Exception getE() {
		return e;
	}
	public void setE(Exception e) {
		this.e = e;
	}
	
	
	
}
