package com.ltq27.Baotrimaylanh.dto.request.employee;

import com.ltq27.Baotrimaylanh.entity.Account;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeUpdate {

    String password;
    String name;
    String phoneNumber;
    String address;
    String birthYear;
    String gender;
}
