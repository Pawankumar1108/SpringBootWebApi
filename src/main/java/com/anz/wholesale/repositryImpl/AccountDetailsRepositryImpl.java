package com.anz.wholesale.repositryImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import com.anz.wholesale.model.AccontTransactionModel;
import com.anz.wholesale.model.AccountDetailsModel;
import com.anz.wholesale.repositry.AccountDetailsRepositry;
import com.anz.wholesale.util.AccountDetailsMapper;
import com.anz.wholesale.util.TransactionofSpecificAccountsMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import static com.anz.wholesale.util.AccountAndTransactionSql.ACCOUNT_LIST_DETAILS;
import static com.anz.wholesale.util.AccountAndTransactionSql.TRANSACTION_ON_SPECIFIC_ACCOUNTS_DETAILS;
import static com.anz.wholesale.util.AccountAndTransactionSql.IS_ACCOUNT_EXIST;

@Repository
public class AccountDetailsRepositryImpl implements AccountDetailsRepositry{
   
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public Set<AccountDetailsModel> getAllAccountList() {
		
		return (Set<AccountDetailsModel>) namedParameterJdbcTemplate.query(ACCOUNT_LIST_DETAILS, new AccountDetailsMapper());
	}
   
	@Override
	public List<AccontTransactionModel> getAccountSpecificTransaction(long accountNumber) throws Exception {
		
		return (List<AccontTransactionModel>) namedParameterJdbcTemplate.query(TRANSACTION_ON_SPECIFIC_ACCOUNTS_DETAILS,getAccountParam(accountNumber) ,new TransactionofSpecificAccountsMapper());
		
	}
    
	
	@Override
	public boolean isAccountNumberExist(long accountNumber) throws Exception {
		
		try {
		long accountNumb = namedParameterJdbcTemplate.queryForObject(IS_ACCOUNT_EXIST,getAccountParam(accountNumber), Long.class);
		return true;
		}catch(Exception e) {
			
			throw new Exception("account number does not exist or some thing goes wrong , Please contact DBA");
		}
	}
	
	private Map<String,Long>  getAccountParam(long accountNumber){
		Map<String , Long> paramMap = new HashMap<>();
		paramMap.put("accountNumber", accountNumber);
		return paramMap;
	}
}