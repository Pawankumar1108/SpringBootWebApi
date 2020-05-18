package com.anz.wholesale.customException;

public class CustomException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String error;
	private String message;
	private String action;
	private String dueTo;
	
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public  String getdueTo() {
		return dueTo;
	}
	public void setCause(String dueTo) {
		this.dueTo = dueTo;
	}
	
	
	protected CustomException() {
		super();
	}
	
	
	
	public CustomException(String error, String message, String action, String dueTo) {
		super();
		this.error = error;
		this.message = message;
		this.action = action;
		this.dueTo = dueTo;
	}
	
	
}



class CompileTimeCustomException extends Exception{
	
	
	private String error;
	private String message;
	private String action;
	private String dueTo;
	
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public  String getdueTo() {
		return dueTo;
	}
	public void setCause(String dueTo) {
		this.dueTo = dueTo;
	}
	
	
	protected CompileTimeCustomException() {
		super();
	}
	
	
	public CompileTimeCustomException(String error, String message, String action, String dueTo) {
		super();
		this.error = error;
		this.message = message;
		this.action = action;
		this.dueTo = dueTo;
	}
	
		
}
