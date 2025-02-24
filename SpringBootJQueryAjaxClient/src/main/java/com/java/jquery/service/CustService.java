package com.java.jquery.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.java.jquery.model.Customer;
import com.java.jquery.repository.CustRepository;

@Service
public class CustService {

    private final CustRepository custRepository;

    public CustService(CustRepository custRepository) {
        this.custRepository = custRepository;
    }

    public Customer save(Customer customer) {
        return custRepository.save(customer);
    }

    public Customer update(Customer customer) {
        return custRepository.save(customer);
    }

    public boolean delete(long id) {  // Fixed type mismatch
        if (custRepository.existsById(id)) {
            custRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Customer> getCustomers() {
        return custRepository.findAll();
    }

    public Optional<Customer> getCustomerByName(String name) {  // Fixed method name
        return custRepository.findByEmail(name);
    }
}
