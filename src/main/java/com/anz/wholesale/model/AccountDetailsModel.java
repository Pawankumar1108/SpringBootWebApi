package com.anz.wholesale.model;

import java.time.LocalDate;

public class AccountDetailsModel {

	private String accountNumber;
	private String accountName;
	private String accountType;
	private LocalDate balanceDate;
	private String currency;
	private double openingAvailableBalance;
	
	@Override
	public boolean equals (Object object) {
		
		 if (object instanceof AccountDetailsModel && object.getClass() == getClass() && ((AccountDetailsModel)object).getAccountNumber().equalsIgnoreCase(this.accountNumber) ) {
			return true;	
		}else {
			return false;
		}
	}
	
	@Override 
	 public int hashCode() { 
		return accountNumber.hashCode();
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public LocalDate getBalanceDate() {
		return balanceDate;
	}
	public void setBalanceDate(LocalDate balanceDate) {
		this.balanceDate = balanceDate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getOpeningAvailableBalance() {
		return openingAvailableBalance;
	}
	public void setOpeningAvailableBalance(double openingAvailableBalance) {
		this.openingAvailableBalance = openingAvailableBalance;
	}
	
	
}
