package com.blogApp.services;

import java.util.List;

import com.blogApp.exceptions.CustomerException;
import com.blogApp.models.Customer;

public interface CustomerService {
	
	public Customer registerCustomer(Customer customer);
	
	public Customer getCustomerDetailsByEmail(String email)throws CustomerException;
	
	public List<Customer> getAllCustomerDetails()throws CustomerException;

}
