package com.anz.wholesale.repositry;

import java.util.List;
import java.util.Set;

import com.anz.wholesale.model.AccontTransactionModel;
import com.anz.wholesale.model.AccountDetailsModel;

public interface AccountDetailsRepositry {

	public Set<AccountDetailsModel> getAllAccountList();
	public List<AccontTransactionModel> getAccountSpecificTransaction(long accountNumber) throws Exception;
	
	public boolean isAccountNumberExist(long accountNumber) throws Exception;
}
