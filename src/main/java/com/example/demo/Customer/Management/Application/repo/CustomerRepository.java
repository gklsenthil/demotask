package com.example.demo.Customer.Management.Application.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.Customer.Management.Application.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query("select c from Customer c order by c.customerId limit ?1 offset ?2")
	List<Customer> getCustomerList(int limit, int offset);
	

}
