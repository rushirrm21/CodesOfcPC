package com.cust.jpa.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cust.jpa.entity.Customer;
import com.cust.jpa.repository.CustomerRepo;

@Service
public class CustService {

	@Autowired
	CustomerRepo custRepo;

	public Customer addProduct(Customer customer) {
		return custRepo.save(customer);
	}

	public List<Customer> getAllCustomers() {
		return custRepo.findAll();
	}

	public Customer getCustomerById(int id) {
		Optional<Customer> customer = custRepo.findById(id);
		if (customer.isPresent())
			return customer.get();
		else
			return null;

	}

	public List<Customer> getAllCustomersOnAvailableBalance(int bal) {
		List<Customer> custlist = null;
		custlist = custRepo.getAllCustomersOnAvailableBalance(bal);
		return custlist;
	}

}
