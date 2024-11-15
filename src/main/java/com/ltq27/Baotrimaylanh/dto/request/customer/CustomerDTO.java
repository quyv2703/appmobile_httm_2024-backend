package com.ltq27.Baotrimaylanh.dto.request.customer;

import com.ltq27.Baotrimaylanh.entity.Customer;
import lombok.Data;

@Data
public class CustomerDTO {
    private String name;
    private String phoneNumber;
    private String address;
    private String birthYear;
    private String gender;

    public CustomerDTO(Customer customer) {
        this.name = customer.getName();
        this.phoneNumber = customer.getPhoneNumber();
        this.address = customer.getAddress();
        this.birthYear = customer.getBirthYear();
        this.gender = customer.getGender();
    }
}