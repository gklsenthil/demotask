package com.example.demo.Customer.Management.Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Customer.Management.Application.RequestDto.CustomerListRequestDto;
import com.example.demo.Customer.Management.Application.entity.Customer;
import com.example.demo.Customer.Management.Application.responseDto.CustomerListResponseDto;
import com.example.demo.Customer.Management.Application.service.CustomerService;

@RestController
@RequestMapping("/v1")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@GetMapping("/getById")
	public ResponseEntity<?> getCustomerById(@RequestBody Customer customer) {
		return customerService.getCustomerById(customer.getCustomerId());
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<CustomerListResponseDto> getAllCustomer(@RequestBody CustomerListRequestDto customerListRequestDto) {
		return customerService.getCustomerList(customerListRequestDto);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> modifyCustomer(@RequestBody Customer customer) {
		return customerService.modifyCustomer(customer);
	}

}
