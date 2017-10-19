package com.techandsolve.atm.core;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAccountsTransactionsEngine implements AccountsTransactionsEngine {

	private static List<Transaction> transactions = new ArrayList<>();
	
	@Override
	public long deposit(String targetAccountNumber, float ammount) {
		synchronized(transactions) {
			transactions.add(new Transaction(targetAccountNumber, ammount));
			return transactions.size();
		}
	}

}
