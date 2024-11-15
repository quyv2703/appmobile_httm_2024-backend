package com.ltq27.Baotrimaylanh.service;

import com.ltq27.Baotrimaylanh.dto.request.AccountUpdate;
import com.ltq27.Baotrimaylanh.dto.request.customer.CustomerUpdate;
import com.ltq27.Baotrimaylanh.dto.request.employee.EmployeeUpdate;
import com.ltq27.Baotrimaylanh.entity.Account;
import com.ltq27.Baotrimaylanh.entity.Customer;
import com.ltq27.Baotrimaylanh.entity.Employee;
import com.ltq27.Baotrimaylanh.entity.Role;
import com.ltq27.Baotrimaylanh.repository.AccountRepository;
import com.ltq27.Baotrimaylanh.repository.CustomerRepository;
import com.ltq27.Baotrimaylanh.repository.EmployeeRepository;
import com.ltq27.Baotrimaylanh.repository.RoleRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service

public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    // khách hàng
    public List<Customer> getListCustomer(){
       return customerRepository.findAll();
    }
    public Optional<Customer> getCustomerById(Long id){
        return customerRepository.findById(id);
    }
    public Customer updateCustomer(Long id, CustomerUpdate customerUpdate, AccountUpdate accountUpdate) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khách hàng"));
        Account account = updateAccount(customer.getAccount().getUsername(),
                accountUpdate.getPassword(),
                accountUpdate.getRoleName(),
                accountUpdate.isActive());

        customer.setAccount(account);
        customer.setName(customerUpdate.getName());
        customer.setPhoneNumber(customerUpdate.getPhoneNumber());
        customer.setAddress(customerUpdate.getAddress());
        customer.setBirthYear(customerUpdate.getBirthYear());
        customer.setGender(customerUpdate.getGender());
        return customerRepository.save(customer);
    }
    // nhân viên
    public List<Employee> getListEmployee(){
        return employeeRepository.findAll();
    }
    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }
    @Transactional
    public Employee updateEmployee(Long id, EmployeeUpdate employeeUpdate, AccountUpdate accountUpdate){
        Employee employee=employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Không tìm thấy nhân viên"));



        Account account = updateAccount(employee.getAccount().getUsername(),
                accountUpdate.getPassword(),
                accountUpdate.getRoleName(),
                accountUpdate.isActive()
        );

        employee.setAccount(account);
        employee.setName(employeeUpdate.getName());
        employee.setPhoneNumber(employeeUpdate.getPhoneNumber());
        employee.setAddress(employeeUpdate.getAddress());
        employee.setBirthYear(employeeUpdate.getBirthYear());
        employee.setGender(employeeUpdate.getGender());

        return employee;
    }



    public Account login(String username, String password) {
        Account account = accountRepository.findById(username).orElse(null);
        if (account != null && passwordEncoder.matches(password, account.getPassword()) && account.isActive()) {
            return account;
        }
        return null;
    }

    @Transactional
    public Account createAccount(String username, String password, String roleName, boolean isActive) {
        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        Account account = new Account();
        account.setUsername(username);
        account.setPassword(passwordEncoder.encode(password));
        account.setRole(role);
        account.setActive(isActive);

        return accountRepository.save(account);
    }
    @Transactional
    public Account updateAccount( String username, String password, String roleName, boolean isActive) {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Account not found"));


        if (password != null && !password.isEmpty()) {
            account.setPassword(passwordEncoder.encode(password));
        }

        if (roleName != null) {
            Role role = roleRepository.findByName(roleName)
                    .orElseThrow(() -> new RuntimeException("Role not found"));
            account.setRole(role);
        }

        account.setActive(isActive);

        return account;
    }

    @Transactional
    public Customer createCustomer(String username, String password,String name, String phoneNumber,String address, String birthYear, String gender) {
        Account account = createAccount(username, password, "CUSTOMER", true);

        Customer customer = new Customer();
        customer.setAccount(account);
        customer.setName(name);
        customer.setPhoneNumber(phoneNumber);
        customer.setAddress(address);
        customer.setBirthYear(birthYear);
        customer.setGender(gender);

        return customerRepository.save(customer);
    }
    @Transactional
    public Employee createEmployee(String username, String password,String name, String phoneNumber, String address, String birthYear, String gender, String idCard) {
        Account account = createAccount(username, password, "EMPLOYEE", true);

        Employee employee = new Employee();
        employee.setAccount(account);
        employee.setName(name);
        employee.setPhoneNumber(phoneNumber);
        employee.setAddress(address);
        employee.setBirthYear(birthYear);
        employee.setGender(gender);
        employee.setIdCard(idCard);

        return employeeRepository.save(employee);
    }

    @Transactional
    public Employee createAdminAccount(String username, String password,String name, String phoneNumber, String address, String birthYear, String gender,  String idCard) {
        Account account = createAccount(username, password, "ADMIN", true);

        Employee employee = new Employee();
        employee.setAccount(account);
        employee.setName(name);
        employee.setPhoneNumber(phoneNumber);
        employee.setAddress(address);
        employee.setBirthYear(birthYear);
        employee.setGender(gender);
        employee.setIdCard(idCard);
        return employeeRepository.save(employee);
    }
}
