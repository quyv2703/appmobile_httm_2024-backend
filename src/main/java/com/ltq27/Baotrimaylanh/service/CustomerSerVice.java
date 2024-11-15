package com.ltq27.Baotrimaylanh.service;

import com.ltq27.Baotrimaylanh.dto.request.customer.CustomerDTO;
import com.ltq27.Baotrimaylanh.entity.Customer;
import com.ltq27.Baotrimaylanh.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerSerVice {
    @Autowired
    private CustomerRepository customerRepository;
    public Long getCustomerIdByUsername(String username) {
        Customer customer = customerRepository.findByAccountUsername(username);
        if (customer != null) {
            return customer.getId();
        }
        return null; // Hoặc xử lý lỗi nếu không tìm thấy
    }
    public CustomerDTO getCustomerByUsername(String username) {
        Customer customer = customerRepository.findByAccountUsername(username);
        if (customer == null) {
            return null;
        }
        return new CustomerDTO(customer);
    }
}
