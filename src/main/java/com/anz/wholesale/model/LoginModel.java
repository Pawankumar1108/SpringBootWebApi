package com.anz.wholesale.model;



public class LoginModel {
	
	private String userId;
	private String userName;
    private String userPassword;

    char[] passwordInCharArray = userPassword.toCharArray();
	/* Arrays.fill(passwordInCharArray, '*'); */
	
   
	public char[] getPasswordInCharArray() {
		return passwordInCharArray;
	}

	public void setPasswordInCharArray(char[] passwordInCharArray) {
		this.passwordInCharArray = passwordInCharArray;
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
