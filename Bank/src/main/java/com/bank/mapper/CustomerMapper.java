package com.bank.mapper;

import com.bank.dto.CustomerDTO;
import com.bank.entity.Customer;

public class CustomerMapper {

	public static Customer dtoToEntity(CustomerDTO customerDTO) {
		
		Customer c=new Customer();
		c.setId(customerDTO.getId());
		c.setEmail(customerDTO.getEmail());
		c.setCustomerName(customerDTO.getCustomerName()); 
		return c;
	}
	public static CustomerDTO entityToDTO(Customer customer) {
		
		CustomerDTO cd=new CustomerDTO();
		cd.setId(customer.getId());
		cd.setEmail(customer.getEmail());
		cd.setCustomerName(customer.getCustomerName());
		return cd;
	}
	
}
