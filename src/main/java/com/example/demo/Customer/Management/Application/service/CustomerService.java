package com.example.demo.Customer.Management.Application.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.Customer.Management.Application.RequestDto.CustomerListRequestDto;
import com.example.demo.Customer.Management.Application.entity.Customer;
import com.example.demo.Customer.Management.Application.responseDto.CustomerListResponseDto;

public interface CustomerService {

	ResponseEntity<String> saveCustomer(Customer customer);

	ResponseEntity<?> getCustomerById(Long customerId);

	ResponseEntity<CustomerListResponseDto> getCustomerList(CustomerListRequestDto customerListRequestDto);

	ResponseEntity<String> modifyCustomer(Customer customer);

}
