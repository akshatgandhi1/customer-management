package com.service;

import java.util.List;

import com.dto.CustomerDto;

public interface CustomerService {

	public CustomerDto createcustomer(CustomerDto customerDto);
	
	public List<CustomerDto> getAllCustomer();
	
	public CustomerDto updateCustomer(CustomerDto customerDto);
	
	public void deleteCustomer(Integer customerId);
	
}
