package com.ltq27.Baotrimaylanh.dto.request.employee.dto;

import com.ltq27.Baotrimaylanh.entity.Customer;
import com.ltq27.Baotrimaylanh.entity.Employee;
import lombok.Data;

@Data
public class EmployeeInforDTO {
    private String name;
    private String phoneNumber;
    private String address;
    private String birthYear;
    private String gender;

    public EmployeeInforDTO(Employee employee) {
        this.name = employee.getName();
        this.phoneNumber = employee.getPhoneNumber();
        this.address = employee.getAddress();
        this.birthYear = employee.getBirthYear();
        this.gender = employee.getGender();
    }
}
