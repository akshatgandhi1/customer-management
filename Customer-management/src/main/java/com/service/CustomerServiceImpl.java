package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.CustomerDto;
import com.dto.DetailsDto;
import com.entity.Customer;
import com.entity.Details;
import com.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ModelMapper mapper;
	
	@Override
	public CustomerDto createcustomer(CustomerDto customerDto) {
		Customer customer= mapper.map(customerDto, Customer.class);
		customerRepository.save(customer);
		return mapper.map(customer, CustomerDto.class);
	}

	@Override
	public List<CustomerDto> getAllCustomer() {
		List<Customer> customer= customerRepository.findAll();
		
		return customer.stream().map((customers) -> mapper.map(customers, CustomerDto.class))
				.collect(Collectors.toList());

	}

	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto) {
		Customer customer=customerRepository.findById(customerDto.getCustomerid()).get();
		Details details=new Details();
		customer.setName(customerDto.getName());
		customer.setAccountType(customerDto.getAccountType());
		customer.setBusinessRequirements(customerDto.getBusinessRequirements());
		customer.setContractType(customerDto.getContractType());
		DetailsDto detailsDto = customerDto.getDetail();
		details.setDob(detailsDto.getDob());
		details.setSex(detailsDto.getSex());
		details.setNativ(detailsDto.getNativ());
		
		Customer updateCustomer=customerRepository.save(customer);
		
		return mapper.map(updateCustomer, CustomerDto.class);
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		customerRepository.delete(customerId);
	}
	
	
	
}
