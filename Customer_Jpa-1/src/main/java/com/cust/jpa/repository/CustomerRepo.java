package com.cust.jpa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cust.jpa.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c where c.balanceAvailable>?1")
	public List<Customer> getAllCustomersOnAvailableBalance(int availableBalance);
}
