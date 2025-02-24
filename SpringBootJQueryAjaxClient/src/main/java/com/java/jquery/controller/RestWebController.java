package com.java.jquery.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.java.jquery.model.Customer;
import com.java.jquery.model.Customer;
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

    @PostMapping("/delete")  // Fixed delete method
    public boolean deleteCustomer(@RequestBody Customer customer) {
        return custService.delete(customer.getId());
    }

    @GetMapping("/getAll")
    public List<Customer> getAllCustomers() {
        return custService.getCustomers();
    }

    @GetMapping("/{name}")  // Fixed path variable name
   public Optional<Customer> getCustomerByName(@PathVariable String name) {
        return custService.getCustomerByName(name);
    }

}
