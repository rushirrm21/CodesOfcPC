package com.cust.jpa;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cust.jpa.entity.Customer;
import com.cust.jpa.entity.Transaction;
import com.cust.jpa.exception.CustomerNotFoundException;
import com.cust.jpa.exception.InsufficientBalanceAvailableException;
import com.cust.jpa.service.CustService;
import com.cust.jpa.service.TransService;

@SpringBootApplication
public class CustomerJpa1Application {

	public static void main(String[] args) {
		ApplicationContext applncnxt = SpringApplication.run(CustomerJpa1Application.class, args);
		CustService custService = applncnxt.getBean(CustService.class);
		TransService transService = applncnxt.getBean(TransService.class);
		////////////CUSTOMER
//		Customer cust1 = new Customer(123,"HRushi","FFFFF0000P",123456,5000);
//		custService.addProduct(cust1);
//		Customer cust2 = new Customer(125,"Ram","FFFFF0000F",654321,3000);
//		custService.addProduct(cust2);
//		
//		List<Customer> custList = custService.getAllCustomers();
//		custList.stream().forEach(c->{
//			System.out.println(c.getCustId()+"  "+c.getCustName()+"  "+c.getPanNo()+"  "+c.getAccountNo()+"  "+c.getBalanceAvailable());
//		});
//		
//		Customer c = custService.getCustomerById(123);
//		if(c!=null){
//			System.out.println(c.getCustId()+"  "+c.getCustName()+"  "+c.getPanNo()+"  "+c.getAccountNo()+"  "+c.getBalanceAvailable());
//		}
//		else {
//			System.out.println("Customer not found");
//		}
//		//////////CUSTOMER
		
		
		////////////Transaction
		
//		try {
//			Transaction transaction = transService.makeTransaction(123, 100, "Deposit", "Cash");
//			System.out.println("Transaction Successfull, Transaction ID: "+transaction.getTransId());
//		} catch (CustomerNotFoundException | InsufficientBalanceAvailableException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		
//		List<Transaction> transList = transService.getAllTransactions();
//		transList.stream().forEach(t->
//		{
//			System.out.println(t.getTransId()+"  "+t.getTransAmount()+"  "+t.getTransType()+"  "+t.getTransMode()+" "+t.getCustomer().getCustId());
//		});
		
		List<Customer> custListt = custService.getAllCustomersOnAvailableBalance(4500);
		custListt.stream().forEach(c->{
		System.out.println(c.getCustId()+"  "+c.getCustName()+"  "+c.getPanNo()+"  "+c.getAccountNo()+"  "+c.getBalanceAvailable());
	});
	////////////Transaction
	System.out.println("Hello Spring Boot App is Running");
		}
}
