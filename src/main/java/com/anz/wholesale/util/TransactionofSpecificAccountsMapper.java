package com.anz.wholesale.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;

import org.springframework.jdbc.core.RowMapper;

import com.anz.wholesale.model.AccontTransactionModel;
import com.anz.wholesale.model.AccountDetailsModel;

public class TransactionofSpecificAccountsMapper implements RowMapper {

	
	public AccontTransactionModel mapRow(ResultSet resultSet, int rowNum) throws SQLException {  
		AccontTransactionModel accountTransactionModel = new AccontTransactionModel();  
		accountTransactionModel.setAccountNumber(resultSet.getString("ACCOUNT_NUMBER"));
		accountTransactionModel.setAccountName(resultSet.getString("ACCOUNT_NAME"));
		accountTransactionModel.setCurrency(resultSet.getString("CURRENCY"));
		accountTransactionModel.setDebitAmount(resultSet.getDouble("DEBIT_AMOUNT"));
		accountTransactionModel.setCreditAmount(resultSet.getDouble("CREDIT_AMOUNT"));
		accountTransactionModel.setDebitOrCreditType(resultSet.getString("DEBIT_OR_CREDIT"));
		accountTransactionModel.setTransactionNarrative(resultSet.getString("TRANSACTION_NARRATIVE"));
		return accountTransactionModel;  
	}  
}
