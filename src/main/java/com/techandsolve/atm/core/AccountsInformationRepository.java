package com.techandsolve.atm.core;

public interface AccountsInformationRepository {

	Account getAccountByNumber(String number);
	//long deposit(String targetAccountNumber, float ammount);
	
}
