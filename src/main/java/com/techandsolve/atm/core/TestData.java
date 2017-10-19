package com.techandsolve.atm.core;

import java.util.List;
import java.util.stream.Collectors;

public class TestData {
	
	private List<Account> accounts;

	public TestData() {
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Account getAccountByNumber(String number) {
		if (this.accounts == null || this.accounts.size() == 0) {
			return null;
		}
		List<Account> filtered = this.accounts.stream().filter(a -> a.getNumber().equals(number)).collect(Collectors.toList());
		if (filtered == null || filtered.size() == 0) {
			return null;
		}
		return filtered.get(0);
	}
	
}
