package com.ltq27.Baotrimaylanh.service;

import com.ltq27.Baotrimaylanh.dto.request.customer.CustomerDTO;
import com.ltq27.Baotrimaylanh.dto.request.employee.EmployeeDTO;
import com.ltq27.Baotrimaylanh.dto.request.employee.dto.EmployeeInforDTO;
import com.ltq27.Baotrimaylanh.entity.Customer;
import com.ltq27.Baotrimaylanh.entity.Employee;
import com.ltq27.Baotrimaylanh.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployeesByRoleId(Long roleId) {
        return employeeRepository.findByAccountRoleId(roleId);
    }
    public Long getCustomerIdByUsername(String username) {
        Employee employee = employeeRepository.findByAccountUsername(username);
        if (employee != null) {
            return employee.getId();
        }
        return null; // Hoặc xử lý lỗi nếu không tìm thấy
    }
    public EmployeeInforDTO getCustomerByUsername(String username) {
        Employee employee = employeeRepository.findByAccountUsername(username);
        if (employee == null) {
            return null;
        }
        return new EmployeeInforDTO(employee);
    }
}
