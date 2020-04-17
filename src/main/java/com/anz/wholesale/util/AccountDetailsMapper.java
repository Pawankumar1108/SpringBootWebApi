package com.anz.wholesale.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;

import org.springframework.jdbc.core.RowMapper;

import com.anz.wholesale.model.AccountDetailsModel;

public class AccountDetailsMapper implements RowMapper {

	public AccountDetailsModel mapRow(ResultSet resultSet, int rowNum) throws SQLException {  
		AccountDetailsModel accountDetailsModel = new AccountDetailsModel();  
		accountDetailsModel.setAccountNumber(resultSet.getString("ACCOUNT_NUMBER"));
		accountDetailsModel.setAccountName(resultSet.getString("ACCOUNT_NAME"));
		accountDetailsModel.setAccountType(resultSet.getString("ACCOUNT_TYPE"));
		accountDetailsModel.setBalanceDate(resultSet.getDate("BALANCE_DATE").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		accountDetailsModel.setCurrency(resultSet.getString("CURRENCY"));
		accountDetailsModel.setOpeningAvailableBalance(resultSet.getDouble("OPENING_AVAILABLE_BALANCE"));
		
		return accountDetailsModel;  
	}  
}
