package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dto.CustomerDto;
import com.service.CustomerServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class CustomerController {

	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public CustomerDto addNewCustomer(@Valid @RequestBody CustomerDto customerDto) {
		return customerServiceImpl.createcustomer(customerDto);
		
	}
	
	@GetMapping("/getAllData")
	@ResponseStatus(code = HttpStatus.OK)
	public List<CustomerDto> getAllCustomer(){
		return customerServiceImpl.getAllCustomer();
	}
	
	@PutMapping("/updateCustomer/{customerid}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public CustomerDto updateCustomer(@PathVariable("customerid") Integer customerid,@Valid @RequestBody CustomerDto customerDto) {
		customerDto.setCustomerid(customerid);
		return customerServiceImpl.updateCustomer(customerDto);
	}
	
	@DeleteMapping("/deleteCustomer/{customerid}")
	@ResponseStatus(code = HttpStatus.OK)
	public void deleteCustomer(@PathVariable("customerid") Integer customerid) {
		customerServiceImpl.deleteCustomer(customerid);
 }
	
}
