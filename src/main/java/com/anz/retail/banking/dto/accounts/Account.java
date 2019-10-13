package com.anz.retail.banking.dto.accounts;

import io.swagger.annotations.ApiModelProperty;

public class Account {
	
	@ApiModelProperty(notes = "Account Number")
	private String number;
	@ApiModelProperty(notes = "Account Name")
	private String name;
	@ApiModelProperty(notes = "Account Type")
	private String type;
	@ApiModelProperty(notes = "Balance Date")
	private String balanceDate;
	@ApiModelProperty(notes = "Account Currency")
	private String currency;
	@ApiModelProperty(notes = "Opening Available Balance")
	private String openingBalance;
	@ApiModelProperty(notes = "AccountId - will be used for invoking User Transactions API")
	private Long accountId;
	
	
	public Long getAccountId() {
		return accountId;
	}


	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}


	public Account() {
		super();
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getBalanceDate() {
		return balanceDate;
	}


	public void setBalanceDate(String balanceDate) {
		this.balanceDate = balanceDate;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getOpeningBalance() {
		return openingBalance;
	}


	public void setOpeningBalance(String openingBalance) {
		this.openingBalance = openingBalance;
	}


	public Account(Long accountId, String number, String name, String type, String balanceDate, String currency,
			String openingBalance) {
		super();
		this.accountId = accountId;
		this.number = number;
		this.name = name;
		this.type = type;
		this.balanceDate = balanceDate;
		this.currency = currency;
		this.openingBalance = openingBalance;
	}
	
	

}
