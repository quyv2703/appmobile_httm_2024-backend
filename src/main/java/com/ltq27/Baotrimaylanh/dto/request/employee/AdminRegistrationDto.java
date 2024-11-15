package com.ltq27.Baotrimaylanh.dto.request.employee;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdminRegistrationDto {
    String username;
    String password;
    String name;
    String phoneNumber;
    String address;
    String birthYear;
    String gender;
    String idCard;
}