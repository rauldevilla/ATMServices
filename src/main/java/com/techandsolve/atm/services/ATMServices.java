package com.techandsolve.atm.services;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techandsolve.atm.core.InvalidAccountException;
import com.techandsolve.atm.core.TransactionsManager;

@RestController
public class ATMServices {
	private static Logger logger = Logger.getLogger(ATMServices.class); 

	@RequestMapping(value = "/ATM/deposit", produces = "application/json", method = RequestMethod.GET)
	public ResponseEntity<TransactionResultDTO> deposit(@RequestParam("a") String targetAccountNumber, @RequestParam("m") float ammount) {
		TransactionsManager transactionsManager = TransactionsManagerBuilder.build();
		long transactionId = -1;
		try {
			transactionId = transactionsManager.deposit(targetAccountNumber, ammount);
		} catch (InvalidAccountException e) {
			logger.error(e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(new TransactionResultDTO(transactionId), HttpStatus.OK);
	}

}
