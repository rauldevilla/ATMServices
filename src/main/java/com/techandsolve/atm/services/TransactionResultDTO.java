package com.techandsolve.atm.services;

public class TransactionResultDTO {

	private long transactionId;
	
	public TransactionResultDTO() {
	}

	public TransactionResultDTO(long transactionId) {
		this.transactionId = transactionId;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	
}
