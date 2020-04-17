package com.anz.wholesale.serviceImpl;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anz.wholesale.model.AccontTransactionModel;
import com.anz.wholesale.model.AccountDetailsModel;
import com.anz.wholesale.repositry.AccountDetailsRepositry;
import com.anz.wholesale.service.WholesaleService;

@Service("wholesaleService")
public class WholesaleServiceImpl implements WholesaleService{

	 @Autowired AccountDetailsRepositry accountDetailsRepositry;
	 
	
	@Override
	public Set<AccountDetailsModel> getAccountsList() throws Exception {
		 
		return accountDetailsRepositry.getAllAccountList();	 
	}

	@Override
	public List<AccontTransactionModel> getTransactionByAccount(long accountNumber) throws Exception {
		
		boolean isAccountNumberExist =isAccountNumberExist(accountNumber);
		if(isAccountNumberExist) {
			return accountDetailsRepositry.getAccountSpecificTransaction(accountNumber);
		} else {
			throw new Exception();
		}
	
	}


	public boolean isAccountNumberExist(long accountNumber) throws Exception {
		
		return accountDetailsRepositry.isAccountNumberExist(accountNumber);
	}

	
}
