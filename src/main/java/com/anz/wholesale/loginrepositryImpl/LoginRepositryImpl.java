package com.anz.wholesale.loginrepositryImpl;

import static  com.anz.wholesale.loginrepositryImpl.LoginRepositrySql.IS_USER_ID_EXIST;
import static  com.anz.wholesale.loginrepositryImpl.LoginRepositrySql.IS_USER_PASSWORD_EXIST;
import static  com.anz.wholesale.loginrepositryImpl.LoginRepositrySql.GET_ALL_USER_SQL;
import static  com.anz.wholesale.loginrepositryImpl.LoginRepositrySql.USER_PASSWORD_UPDATED;
import static  com.anz.wholesale.loginrepositryImpl.LoginRepositrySql.NEW_USER_INSERTED;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ListModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.anz.wholesale.loginrepositry.LoginRepositry;
import com.anz.wholesale.model.LoginModel;
import com.anz.wholesale.util.LoginMapper;
import static  com.anz.wholesale.loginrepositryImpl.LoginRepositrySql.USER_WITH_PIN_PASSWORD;
@Repository("loginImpl")
public class LoginRepositryImpl  implements LoginRepositry  {
 
	
	private static final Logger LOGGER = LogManager.getLogger(LoginRepositryImpl.class);
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;


	@Override
	public boolean isUserIdExist(String userId) throws Exception {
		Map<String , String> paramMap = new HashMap<>();
		paramMap.put("userId", userId);
		try {

			LoginModel LoginModel = namedParameterJdbcTemplate.queryForObject(IS_USER_ID_EXIST,paramMap , new LoginMapper());
 
			return true;
			
		}catch(Exception e) {
			throw new Exception("This user doesn't Exist");

		}
	}

	public List<LoginModel> getAllUser() throws Exception {
		Map<String , String> paramMap = new HashMap<>();
		
			
		 try {
			List<LoginModel>  userList = namedParameterJdbcTemplate.query(GET_ALL_USER_SQL,paramMap , new LoginMapper());
			
			return userList;
			
		 }catch(Exception e) {
			 throw new Exception("Database Error occured");
		 }

		}
	

	@Override
	public boolean isUserPasswordExist(String userPassword) {
		Map<String , String> paramMap = new HashMap<>();
		paramMap.put("userPassword", userPassword);
		
		
			LoginModel  loginModel= namedParameterJdbcTemplate.queryForObject(IS_USER_PASSWORD_EXIST,paramMap , new LoginMapper());
			
			if(loginModel !=null) {
			return true;
			}else{
				
				throw new RuntimeException("This UserPassword  doesn't Exist , Please Contact DBA");	
				
			}
			
			

	}

	@Override
	public boolean getUserPasswordUpdate(String userPassword,String userId)  {
		
		  Map<String , String> paramMap = new HashMap<>();
		  paramMap.put("userPassword", userPassword);
		  paramMap.put("userId", userId);

			int updateRecordCount = namedParameterJdbcTemplate.update(USER_PASSWORD_UPDATED,paramMap);
			if(updateRecordCount != 0) {
				return true;
			}else {
				throw new RuntimeException("user Does not exist or some DB error while updating the password");
			}
	}

	@Override
	public boolean createNewUser(String userId, String userPassword, String userName) {


		Map<String,String>paramMap= new HashMap<>();
		paramMap.put("userId" , userId);
		paramMap.put("userPassword", userPassword);
		paramMap.put("userName", userName);

		int  newUser =namedParameterJdbcTemplate.update(NEW_USER_INSERTED, paramMap);

		if(newUser !=0) {
			return true;
		}else {	 

			throw new RuntimeException("Not able to insert New User please Contact the DBA");

		}

	}

	/*
	 * @Override public boolean getUserWithPin(String userId, String userPassword,
	 * Character[] userpin, String userName) {
	 * 
	 * 
	 * 
	 * Map<String,String>paramMap=new HashMap<>(); paramMap.put("userId", userId);
	 * paramMap.put("userPassword", userPassword); paramMap.put("userName",
	 * userName); //paramMap.putAll(paramMap2);
	 * 
	 * Map<Character[],Character[]>paramMap2=new HashMap<>();
	 * paramMap2.putAll(paramMap); paramMap2.put(userpin, userpin);
	 * 
	 * 
	 * int newPinUser =namedParameterJdbcTemplate.update(USER_WITH_PIN_PASSWORD,
	 * paramMap);
	 * 
	 * if(newPinUser !=0) { return true; }else { throw new
	 * RuntimeException("The New User Can't be Created"); } }
	 */
	
	


	
	

	

}	

	


