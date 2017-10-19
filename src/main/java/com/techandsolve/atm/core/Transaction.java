package com.techandsolve.atm.core;

public class Transaction {

	private String accountNumber;
	private float ammount = 0;
	
	public Transaction() {
	}
	
	public Transaction(String accountNumber, float ammount) {
		this.accountNumber = accountNumber;
		this.ammount = ammount;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public float getAmmount() {
		return ammount;
	}

	public void setAmmount(float ammount) {
		this.ammount = ammount;
	}
	
}
