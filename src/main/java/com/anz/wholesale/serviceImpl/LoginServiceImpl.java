package com.anz.wholesale.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anz.wholesale.loginrepositry.LoginRepositry;
import com.anz.wholesale.model.LoginModel;
import com.anz.wholesale.service.LoginService;

@Service("loginServices")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginRepositry loginRepositry;


	@Override
	public boolean isUserIdExist(String userId) throws Exception {
		
		return loginRepositry.isUserIdExist(userId);
	}


	@Override
	public List<LoginModel> getAllUser() throws Exception {
		
		return loginRepositry.getAllUser() ;
	}


	@Override
	public boolean isUserPasswordExist(String userPassword)throws Exception {
		
		return loginRepositry.isUserPasswordExist(userPassword);
	}

    @Override
    public boolean getUserPasswordUpdate(String userPassword,String userId)throws Exception{
		
		
			return loginRepositry.getUserPasswordUpdate(userPassword,userId);
		
	}


	@Override
	public boolean createNewUser(String userId, String userPassword, String userName) {
		
		return loginRepositry.createNewUser(userId,userPassword,userName);
	}


	@Override
	public boolean getUserWithPin(String userId, String userPassword, Character[] userpin, String userName)
			throws Exception {
		
		return loginRepositry.getUserWithPin(userId,userPassword,userpin,userName);
	}





}	



	
	
	
    
   


	

	
	




