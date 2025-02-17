package com.java.jquery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.jquery.custdao.CustDao;
import com.java.jquery.model.Customer;

@RestController
@RequestMapping("/customer")
public class RestWebController {

	@Autowired
	CustDao dao;

	@GetMapping(value = "/getAll")
	public List<Customer> getResource() {
		List<Customer> cust = dao.getCustomers();
		return cust;
	}

	@PostMapping(value = "/delete")
	public boolean delete(@RequestBody Customer customer) {
		boolean result = dao.delete(customer.getEmployeeId());
		return result;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Boolean editsave(@RequestBody Customer customer) {
		dao.update(customer);
		return Boolean.TRUE;
	}

	@PostMapping(value = "/save")
	public Boolean postCustomer(@RequestBody Customer customer) {
		dao.save(customer);
		return Boolean.TRUE;
	}
	
	@GetMapping(value = "/hello")
	public String getH() {
		 
		return "Hellow World";
	}
	
	@PostMapping(value = "/postData")
	public Customer postData(@RequestBody Customer customer) {
		 
		return customer;
	}
	
	  
}