package com.example.demo.Customer.Management.Application.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Customer.Management.Application.RequestDto.CustomerListRequestDto;
import com.example.demo.Customer.Management.Application.entity.Customer;
import com.example.demo.Customer.Management.Application.repo.CustomerRepository;
import com.example.demo.Customer.Management.Application.responseDto.CustomerListResponseDto;
import com.example.demo.Customer.Management.Application.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public ResponseEntity<String> saveCustomer(Customer customer) {
		try {
			customerRepository.save(customer);
		}catch (Exception e) {
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)
		            .body("Customer Creation Failed");
		}
		return ResponseEntity
	            .status(HttpStatus.NOT_FOUND)
	            .body("Customer Created Successfully");
	}

	@Override
	public ResponseEntity<?> getCustomerById(Long customerId) {
		Customer customer = null;
		try {
			customer = customerRepository.findById(customerId).get();
		}catch (Exception e) {
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)
		            .body("Customer Not Found");
		}
		 
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<CustomerListResponseDto> getCustomerList(CustomerListRequestDto customerListRequestDto) {
		List<Customer> customerList= customerRepository.getCustomerList(customerListRequestDto.getLimit(),customerListRequestDto.getOffset());
		CustomerListResponseDto customerListResponseDto = new CustomerListResponseDto();
		customerListResponseDto.setCustomer(customerList);
		customerListResponseDto.setCount(customerList.size());
		return new ResponseEntity<CustomerListResponseDto>(customerListResponseDto,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> modifyCustomer(Customer customer) {
		Customer existedCustomer = null;
		try {
			existedCustomer = customerRepository.findById(customer.getCustomerId()).get();
		}catch (Exception e) {
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)
		            .body("Customer Not Found");
		}
		if(customer.getName()!= null) {
			existedCustomer.setName(customer.getName());
		}
		if(customer.getLastName()!= null) {
			existedCustomer.setLastName(customer.getLastName());
		}
		if(customer.getMobile()!= null) {
			existedCustomer.setMobile(customer.getMobile());
		}
		customerRepository.save(existedCustomer);
		return ResponseEntity
	            .status(HttpStatus.OK)
	            .body("Customer Modified Sucessfully");
	}
	
	

}
