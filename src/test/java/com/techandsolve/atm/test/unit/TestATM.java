package com.techandsolve.atm.test.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techandsolve.atm.core.Account;
import com.techandsolve.atm.core.AccountsInformationRepository;
import com.techandsolve.atm.core.AccountsTransactionsEngine;
import com.techandsolve.atm.core.InMemoryAccountsTransactionsEngine;
import com.techandsolve.atm.core.InvalidAccountException;
import com.techandsolve.atm.core.TestDataRepository;
import com.techandsolve.atm.core.TransactionsManager;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestATM {

	@Test
	public void testInitializeTestData() {
		TestDataRepository.getInstance().init();
	}
	
	@Test(timeout = 2000)
	public void testDepositForActiveAccount() throws InvalidAccountException {
		//ARREANGE ======
		final String targetAccountNumber = "1234567890";
		
		AccountsInformationRepository accountsInformationRepositoryMock = mock(AccountsInformationRepository.class);
		when(accountsInformationRepositoryMock.getAccountByNumber(targetAccountNumber))
			.thenReturn(new Account(targetAccountNumber, 1000f, true));
		
		AccountsTransactionsEngine accountsTransactionsEngine = new InMemoryAccountsTransactionsEngine();
		
		TransactionsManager transactionsManager = new TransactionsManager();
		transactionsManager.setAccountsInformationRepository(accountsInformationRepositoryMock);
		transactionsManager.setAccountsTransactionsEngine(accountsTransactionsEngine);
		
		//ACT ===========
		long transactionId = transactionsManager.deposit(targetAccountNumber, 10);

		//ASSERT ========
		assertTrue(transactionId > 0);
	}

}
