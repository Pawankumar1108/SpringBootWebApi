package com.anz.wholesale.loginrepositry;

import java.util.List;

import com.anz.wholesale.model.LoginModel;

public interface LoginRepositry {

	public boolean isUserIdExist(String userId)throws Exception;
	public List<LoginModel> getAllUser()throws Exception;
	public boolean isUserPasswordExist(String userPaswd)throws Exception;
	
    public boolean getUserPasswordUpdate(String userPassword, String userId);
    
    
	public boolean createNewUser(String userId, String userPassword, String userName);

}
