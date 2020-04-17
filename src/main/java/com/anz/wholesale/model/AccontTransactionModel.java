package com.anz.wholesale.model;

import java.time.LocalDate;


public class AccontTransactionModel {

	private String accountNumber;
	private String accountName;
	private LocalDate valueDate;
	private String currency;
	private double debitAmount;
	private double creditAmount;
	private String debitOrCreditType;
	private String transactionNarrative;
	
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
	public LocalDate getValueDate() {
		return valueDate;
	}
	public void setValueDate(LocalDate valueDate) {
		this.valueDate = valueDate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getDebitAmount() {
		return debitAmount;
	}
	public void setDebitAmount(double debitAmount) {
		this.debitAmount = debitAmount;
	}
	public double getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}
	public String getDebitOrCreditType() {
		return debitOrCreditType;
	}
	public void setDebitOrCreditType(String debitOrCreditType) {
		this.debitOrCreditType = debitOrCreditType;
	}
	public String getTransactionNarrative() {
		return transactionNarrative;
	}
	public void setTransactionNarrative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}
	
	
}
