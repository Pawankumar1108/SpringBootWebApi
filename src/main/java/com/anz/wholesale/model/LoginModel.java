package com.anz.wholesale.model;

public class LoginModel {

	private String userId;
	private String userName;
	private String userPassword;
	private Character [] userpin =new Character[12];




	public Character[] getUserpin() {
		return userpin;
	}

	public void setUserpin(Character[] userpin) {
		this.userpin = userpin;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
