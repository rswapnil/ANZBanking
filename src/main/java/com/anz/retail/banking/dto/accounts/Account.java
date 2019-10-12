package com.anz.retail.banking.dto.accounts;

public class Account {
	
	private String number;
	private String name;
	private String type;
	private String balanceDate;
	private String currency;
	private String openingBalance;
	
	
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


	public Account(String number, String name, String type, String balanceDate, String currency,
			String openingBalance) {
		super();
		this.number = number;
		this.name = name;
		this.type = type;
		this.balanceDate = balanceDate;
		this.currency = currency;
		this.openingBalance = openingBalance;
	}
	
	

}
