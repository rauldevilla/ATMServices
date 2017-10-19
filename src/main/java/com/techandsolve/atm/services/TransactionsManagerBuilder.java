package com.techandsolve.atm.services;

import com.techandsolve.atm.core.AccountsInformationDummy;
import com.techandsolve.atm.core.AccountsTransactionsEngine;
import com.techandsolve.atm.core.InMemoryAccountsTransactionsEngine;
import com.techandsolve.atm.core.TransactionsManager;

public class TransactionsManagerBuilder {

	public static TransactionsManager build() {
		TransactionsManager transactionsManager = new TransactionsManager();
		AccountsTransactionsEngine accountsTransactionsEngine = new InMemoryAccountsTransactionsEngine();
		transactionsManager.setAccountsInformationRepository(new AccountsInformationDummy());
		transactionsManager.setAccountsTransactionsEngine(accountsTransactionsEngine);
		return transactionsManager;
	}

}
