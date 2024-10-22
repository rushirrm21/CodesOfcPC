package com.cust.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cust.jpa.entity.Transaction;

public interface TransRepo extends JpaRepository<Transaction, Integer> {

}
