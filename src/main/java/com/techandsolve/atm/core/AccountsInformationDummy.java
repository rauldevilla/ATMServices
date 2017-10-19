package com.techandsolve.atm.core;

public class AccountsInformationDummy implements AccountsInformationRepository {

	@Override
	public Account getAccountByNumber(String number) {
		return TestDataRepository.getInstance().getTestData().getAccountByNumber(number);
	}

}
