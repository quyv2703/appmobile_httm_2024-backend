package com.ltq27.Baotrimaylanh.dto.response;

import com.ltq27.Baotrimaylanh.entity.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class LoginResponse {
     String message;
     Role role;


}
