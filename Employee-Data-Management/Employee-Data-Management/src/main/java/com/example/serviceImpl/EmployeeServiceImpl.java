package com.example.serviceImpl;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepo;

    public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Page<Employee> getAllEmployees(int page, int pageSize, String sortBy) {
        try {
            int offset = (page - 1) * pageSize;
            Sort sort = Sort.by(sortBy);
            Pageable pageable = PageRequest.of(offset, pageSize, sort);

            return employeeRepo.findAll(pageable);
        }
        catch (Exception e){
            System.out.println("Exception occurred");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public void deleteEmployeeById(String id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public Employee updateEmployeeById(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeRepo.findById(id);
    }
}
