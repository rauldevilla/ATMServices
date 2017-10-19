package com.techandsolve.atm.core;

public class Account {

	private String number;
	private float balance;
	private boolean active; 
	
	public Account() {
	}

	public Account(String number, float balance, boolean active) {
		this.number = number;
		this.balance = balance;
		this.active = active;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
