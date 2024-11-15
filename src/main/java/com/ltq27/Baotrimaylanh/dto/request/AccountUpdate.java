package com.ltq27.Baotrimaylanh.dto.request;

import com.ltq27.Baotrimaylanh.entity.Role;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountUpdate {
    String password;
    String roleName;
    boolean active;
}
