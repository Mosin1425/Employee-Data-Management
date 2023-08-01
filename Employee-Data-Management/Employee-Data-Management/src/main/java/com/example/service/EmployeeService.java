package com.example.service;

import com.example.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    //Creating a employee
    Employee createEmployee(Employee employee);

    //Delete Employee By Id
    void deleteEmployeeById(String id);

    //Update Employee By Id
    Employee updateEmployeeById(Employee employee);

    //Get Employee By Id
    Employee getEmployeeById(String id);

    //All Employee details
    List<Employee> getAllEmployees();

    //Employee Detail with page, sorting and page size
    Page<Employee> getAllEmployees(int page, int pageSize, String sortBy);
}
