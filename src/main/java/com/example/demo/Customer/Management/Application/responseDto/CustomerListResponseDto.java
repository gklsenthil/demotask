package com.example.demo.Customer.Management.Application.responseDto;

import java.util.List;

import com.example.demo.Customer.Management.Application.entity.Customer;

public class CustomerListResponseDto {
	
	private List<Customer> customer;
	
	private int count;

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CustomerListResponseDto [customer=" + customer + ", count=" + count + "]";
	}

}
