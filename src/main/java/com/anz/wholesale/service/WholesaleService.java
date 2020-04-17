package com.anz.wholesale.service;

import java.util.List;
import java.util.Set;

import com.anz.wholesale.model.AccontTransactionModel;
import com.anz.wholesale.model.AccountDetailsModel;


public interface WholesaleService {

	public Set<AccountDetailsModel> getAccountsList() throws Exception;
	
	public List<AccontTransactionModel> getTransactionByAccount(long accountNumber) throws Exception;
	
}
