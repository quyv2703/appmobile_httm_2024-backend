package com.ltq27.Baotrimaylanh.dto.request.employee;

import com.ltq27.Baotrimaylanh.dto.request.AccountUpdate;

public class EmployeeAccountUpdateDTO {
    private EmployeeUpdate employeeUpdate;
    private AccountUpdate accountUpdate;

    public EmployeeUpdate getEmployeeUpdate() {
        return employeeUpdate;
    }

    public void setEmployeeUpdate(EmployeeUpdate employeeUpdate) {
        this.employeeUpdate = employeeUpdate;
    }

    public AccountUpdate getAccountUpdate() {
        return accountUpdate;
    }

    public void setAccountUpdate(AccountUpdate accountUpdate) {
        this.accountUpdate = accountUpdate;
    }
}
