package com.ltq27.Baotrimaylanh.controller;

import com.ltq27.Baotrimaylanh.dto.request.AccountUpdate;
import com.ltq27.Baotrimaylanh.dto.request.ApiResponse;
import com.ltq27.Baotrimaylanh.dto.request.customer.CustomerAccountUpdateDTO;
import com.ltq27.Baotrimaylanh.dto.request.customer.CustomerUpdate;
import com.ltq27.Baotrimaylanh.dto.request.employee.AdminRegistrationDto;

import com.ltq27.Baotrimaylanh.dto.request.customer.CustomerRegistrationDto;
import com.ltq27.Baotrimaylanh.dto.request.employee.EmployeeAccountUpdateDTO;
import com.ltq27.Baotrimaylanh.dto.request.employee.EmployeeRegistrationDto;
import com.ltq27.Baotrimaylanh.entity.*;

import com.ltq27.Baotrimaylanh.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/listcustomer")
    public ApiResponse<List<Customer>> listCustomer(){
        ApiResponse<List<Customer>> apiResponse= new ApiResponse<>();
        List<Customer> customerList=accountService.getListCustomer();
        apiResponse.setResult(customerList);
        return  apiResponse;
    }
    @PostMapping("/customer")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerRegistrationDto dto) {
        Customer customer = accountService.createCustomer(dto.getUsername(), dto.getPassword(), dto.getName(), dto.getPhoneNumber(),dto.getAddress(), dto.getBirthYear(),dto.getGender()  );
        return ResponseEntity.ok(customer);
    }
    @PutMapping("/customer/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id,
                                            @RequestBody CustomerAccountUpdateDTO updateDTO) {
        try {
            Customer updatedCustomer = accountService.updateCustomer(id,
                    updateDTO.getCustomerUpdate(),
                    updateDTO.getAccountUpdate());
            return ResponseEntity.ok(updatedCustomer);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Có lỗi xảy ra khi cập nhật khách hàng");
        }
    }
    @GetMapping("/listemployee")
    public ApiResponse<List<Employee>> listEmployee(){
        ApiResponse<List<Employee>> apiResponse= new ApiResponse<>();
        List<Employee> employeeList= accountService.getListEmployee();
        apiResponse.setResult(employeeList);
        return apiResponse;
    }
    @PutMapping("/employee/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id,
                                            @RequestBody EmployeeAccountUpdateDTO updateDTO) {
        try {
            Employee updatedEmployee = accountService.updateEmployee(id,
                    updateDTO.getEmployeeUpdate(),
                    updateDTO.getAccountUpdate());
            return ResponseEntity.ok(updatedEmployee);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Có lỗi xảy ra khi cập nhật nhân viên");
        }
    }

    @PostMapping("/employee")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeRegistrationDto dto) {
        Employee employee = accountService.createEmployee(dto.getUsername(), dto.getPassword(),dto.getName(),dto.getPhoneNumber(),dto.getAddress(), dto.getBirthYear(),dto.getGender() ,dto.getIdCard());
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/admin")
    public ResponseEntity<?> createAdmin(@RequestBody AdminRegistrationDto dto) {
        Employee employee = accountService.createEmployee(dto.getUsername(), dto.getPassword(),dto.getName(),dto.getPhoneNumber(),dto.getAddress(), dto.getBirthYear(),dto.getGender() ,dto.getIdCard());
        return ResponseEntity.ok(employee);
    }


}