package com.anz.wholesale.service;

import java.util.List;


import com.anz.wholesale.model.LoginModel;

public interface LoginService {

	public boolean isUserIdExist(String userId) throws Exception;
	
	public List<LoginModel> getAllUser() throws Exception;
	
	public boolean isUserPasswordExist(String userPassword) throws Exception;
	
	public boolean getUserPasswordUpdate(String userPassword,String userId)throws Exception;
	
    public boolean createNewUser(String userId, String userPassword, String userName);
    
	/*
	 * public boolean getUserWithPin(String userId, String userPassword, Character[]
	 * userpin, String userName)throws Exception;
	 */
	
	
	

}
