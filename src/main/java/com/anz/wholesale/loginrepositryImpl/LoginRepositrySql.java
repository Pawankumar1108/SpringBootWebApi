package com.anz.wholesale.loginrepositryImpl;


public class LoginRepositrySql {

	public static final String IS_USER_ID_EXIST = "SELECT USER_ID FROM LOGIN_PAGE WHERE USER_ID = :userId";
	
	public static final String GET_ALL_USER_SQL = "SELECT * FROM LOGIN_PAGE";
	
	public static final String IS_USER_PASSWORD_EXIST = "SELECT * FROM LOGIN_PAGE WHERE USER_PASSWORD = :userPassword";
	
	public static final String USER_PASSWORD_UPDATED= "UPDATE LOGIN_PAGE SET USER_PASSWORD = :userPassword WHERE USER_ID = :userId";
	
	public static final String NEW_USER_INSERTED= "INSERT INTO LOGIN_PAGE(USER_ID,USER_PASSWORD,USER_NAME) VALUES(:userId, :userPassword, :userName)";
	
	public static final String USER_WITH_PIN_PASSWORD= "INSERT INTO BLOOD_BANK(USER_ID,USER_PASSWORD,USER_PIN,USER_NAME) VALUES(:userId, :userPassword,:userpin,:userName)";
}
