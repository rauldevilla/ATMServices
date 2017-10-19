package com.techandsolve.atm.core;

public class TransactionsManager {

	private AccountsInformationRepository accountsInformationRepository;
	private AccountsTransactionsEngine accountsTransactionsEngine;
	
	public void setAccountsInformationRepository(AccountsInformationRepository accountsInformationRepository) {
		this.accountsInformationRepository = accountsInformationRepository;		
	}

	public void setAccountsTransactionsEngine(AccountsTransactionsEngine accountsTransactionsEngine) {
		this.accountsTransactionsEngine = accountsTransactionsEngine;
	}

	public long deposit(String targetAccountNumber, float ammount) throws InvalidAccountException {
		
		Account account = this.accountsInformationRepository.getAccountByNumber(targetAccountNumber);
		if (account == null) {
			throw new InvalidAccountException();
		}
		
		if (!account.isActive()) {
			throw new InvalidAccountException();
		}
		
		long transactionId = this.accountsTransactionsEngine.deposit(targetAccountNumber, ammount);
		return transactionId;
	}

}
