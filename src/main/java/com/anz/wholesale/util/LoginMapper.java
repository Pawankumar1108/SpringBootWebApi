package com.anz.wholesale.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.anz.wholesale.model.LoginModel;

public class LoginMapper implements RowMapper<LoginModel> {
	
	public LoginModel mapRow(ResultSet resultSet, int rowNum ) throws SQLException {
		
		LoginModel loginModel = new LoginModel();
		loginModel.setUserId(resultSet.getString("USER_ID"));
		loginModel.setUserPassword(resultSet.getString("USER_PASSWORD"));
		loginModel.setUserName(resultSet.getString("USER_NAME"));
		//loginModel.setUserpin(resultSet.getCharacterStream("USER_PIN"));
		
		return loginModel;
		
	}

		
	
}
