package com.cust.jpa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cust.jpa.entity.Customer;
import com.cust.jpa.entity.Transaction;
import com.cust.jpa.exception.CustomerNotFoundException;
import com.cust.jpa.exception.InsufficientBalanceAvailableException;
import com.cust.jpa.repository.CustomerRepo;
import com.cust.jpa.repository.TransRepo;
import jakarta.transaction.Transactional;

@Service
public class TransService {

	@Autowired
	TransRepo transRepo;

	@Autowired
	CustomerRepo customerRepo;
	
	@Transactional
	public Transaction makeTransaction(int custId, int transAmount, String transType, String transMode)
			throws CustomerNotFoundException, InsufficientBalanceAvailableException {

		Customer customer = customerRepo.findById(custId).orElse(null);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer not found");
		}
		if (transType.equalsIgnoreCase("Withdraw")) {
			if (customer.getBalanceAvailable() - transAmount < 0) {
				throw new InsufficientBalanceAvailableException("Available balance is less than the withdrawl amount");
			}
		}
			Transaction transaction = new Transaction();
			transaction.setCustomer(customer);
			transaction.setTransAmount(transAmount);
			transaction.setTransType(transType);
			transaction.setTransMode(transMode);
			transaction = transRepo.save(transaction);

			if (transType.equalsIgnoreCase("Withdraw")) {
				System.out.println(customer.getBalanceAvailable()+" + "+transAmount+" = "+(customer.getBalanceAvailable() - transAmount));
				customer.setBalanceAvailable((customer.getBalanceAvailable()-transAmount));
			} else {
				System.out.println(customer.getBalanceAvailable()+" + "+transAmount+" = "+(customer.getBalanceAvailable() + transAmount));
				customer.setBalanceAvailable((customer.getBalanceAvailable()+transAmount));
				
			}
			customerRepo.save(customer);
			

		
		return transaction;
	}
	
	public List<Transaction> getAllTransactions(){
		return transRepo.findAll();
	}
}
