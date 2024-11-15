package com.ltq27.Baotrimaylanh.dto.request.customer;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegistrationDto {
    String username;
    String password;
    String name;
    String phoneNumber;
    String address;
    String birthYear;
    String gender;
    // getters and setters
}