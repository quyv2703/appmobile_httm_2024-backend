package com.ltq27.Baotrimaylanh.repository;

import com.ltq27.Baotrimaylanh.dto.request.employee.EmployeeDTO;
import com.ltq27.Baotrimaylanh.entity.Customer;
import com.ltq27.Baotrimaylanh.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

    List<Employee> findByAccountRoleId(Long roleId);
    Employee findByAccountUsername(String username);
}
