package com.anz.retail.banking.dto.transactions;

public class Transaction {
	
	private String accountNumber;
	private String accountName;
	private String valueDate;
	private String currency;
	private String debitAmount;
	private String creditAmout;
	private String debitOrCredit;
	private String transactionNarrative;
	
	public Transaction() {
		super();
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

	public String getValueDate() {
		return valueDate;
	}

	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(String debitAmount) {
		this.debitAmount = debitAmount;
	}

	public String getCreditAmout() {
		return creditAmout;
	}

	public void setCreditAmout(String creditAmout) {
		this.creditAmout = creditAmout;
	}

	public String getDebitOrCredit() {
		return debitOrCredit;
	}

	public void setDebitOrCredit(String debitOrCredit) {
		this.debitOrCredit = debitOrCredit;
	}

	public String getTransactionNarrative() {
		return transactionNarrative;
	}

	public void setTransactionNarrative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}

	public Transaction(String accountNumber, String accountName, String valueDate, String currency, String debitAmount,
			String creditAmout, String debitOrCredit, String transactionNarrative) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.valueDate = valueDate;
		this.currency = currency;
		this.debitAmount = debitAmount;
		this.creditAmout = creditAmout;
		this.debitOrCredit = debitOrCredit;
		this.transactionNarrative = transactionNarrative;
	}

}
