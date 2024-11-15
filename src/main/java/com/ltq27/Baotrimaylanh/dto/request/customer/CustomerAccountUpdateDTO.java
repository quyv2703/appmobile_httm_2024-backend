package com.ltq27.Baotrimaylanh.dto.request.customer;

import com.ltq27.Baotrimaylanh.dto.request.AccountUpdate;

public class CustomerAccountUpdateDTO {
    private CustomerUpdate customerUpdate;
    private AccountUpdate accountUpdate;

    // Getters and setters
    public CustomerUpdate getCustomerUpdate() {
        return customerUpdate;
    }

    public void setCustomerUpdate(CustomerUpdate customerUpdate) {
        this.customerUpdate = customerUpdate;
    }

    public AccountUpdate getAccountUpdate() {
        return accountUpdate;
    }

    public void setAccountUpdate(AccountUpdate accountUpdate) {
        this.accountUpdate = accountUpdate;
    }
}