package com.ltq27.Baotrimaylanh.controller;

import com.ltq27.Baotrimaylanh.dto.request.customer.CustomerDTO;
import com.ltq27.Baotrimaylanh.dto.request.employee.EmployeeDTO;
import com.ltq27.Baotrimaylanh.dto.request.employee.dto.EmployeeInforDTO;
import com.ltq27.Baotrimaylanh.entity.Employee;
import com.ltq27.Baotrimaylanh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/employees")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/by-role/{roleId}")
    public ResponseEntity<List<Employee>> getEmployeesByRoleId(@PathVariable Long roleId) {
        List<Employee> employees = employeeService.getEmployeesByRoleId(roleId);
        return ResponseEntity.ok(employees);
    }
    @GetMapping("/id")
    public ResponseEntity<Long> getCustomerIdByUsername(@RequestParam String username) {
        Long customerId = employeeService.getCustomerIdByUsername(username);
        if (customerId != null) {
            return ResponseEntity.ok(customerId);
        } else {
            return ResponseEntity.status(404).build(); // Not Found
        }
    }
    @GetMapping("/username/{username}")
    public ResponseEntity<EmployeeInforDTO> getCustomerByUsername(@PathVariable String username) {
        EmployeeInforDTO employeeInforDTO = employeeService.getCustomerByUsername(username);
        if (employeeInforDTO == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(employeeInforDTO);
    }
}
