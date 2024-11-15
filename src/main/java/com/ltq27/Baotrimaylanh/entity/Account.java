package com.ltq27.Baotrimaylanh.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Account {
    @Id
    String username;
    String password;
    @ManyToOne
    @JoinColumn(name="role_id")
    Role role;
    boolean isActive;


}