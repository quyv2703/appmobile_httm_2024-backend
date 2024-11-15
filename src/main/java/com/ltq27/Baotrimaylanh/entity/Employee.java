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
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne
    @JoinColumn(name = "username")
    Account account;
    String name;
    String phoneNumber;
    String address;
    String birthYear;
    String gender;
    String idCard;

    // Getters and Setters
}