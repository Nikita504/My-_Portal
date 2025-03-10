package com.java.jquery.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.jquery.model.Customer;
import com.java.jquery.model.UserData;
import com.java.jquery.service.CustService;

@RestController
@RequestMapping("/customer")
public class RestWebController {

	private final CustService custService;

	public RestWebController(CustService custService) {
		this.custService = custService;
	}

	@PostMapping("/save")
	public Customer createCustomer(@RequestBody Customer customer) {
		return custService.save(customer);
	}

	@PostMapping("/update")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return custService.update(customer);
	}

	@PostMapping("/delete") // Fixed delete method
	public boolean deleteCustomer(@RequestBody Customer customer) {
		return custService.delete(customer.getId());
	}

	@GetMapping("/getAll")
	public List<Customer> getAllCustomers() {
		return custService.getCustomers();
	}

	@GetMapping("/{name}") // Fixed path variable name
	public Optional<Customer> getCustomerByName(@PathVariable String name) {
		return custService.getCustomerByName(name);
	}

	@GetMapping("/getAllUserData")
	public List<UserData> getUsers() {
		return List.of(new UserData(1l, "John", "Doe", "America"), new UserData(2l, "Jane", "Smith", "NewYork"),
				new UserData(3l, "Nikita", "Chaudhari", "Aurangabad"), new UserData(4l, "Vedika", "Chaudhari", "Pune"),
				new UserData(5l, "Yogesh", "Solunke", "Pali"));
	}

}