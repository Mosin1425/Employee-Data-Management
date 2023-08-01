package com.example.controller;

import com.example.entity.Employee;
import com.example.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getAll")
    public List<Employee> findAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@RequestBody Employee employee){
        Employee em = employeeService.createEmployee(employee);
        return em.getId();
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable String id){
        employeeService.deleteEmployeeById(id);
        return "Employee with id: '" + id + "' is deleted successfully";
    }

    @PutMapping("updateEmployee/{id}")
    public String updateEmployee(@PathVariable String id, @RequestBody Employee employee){
        Employee newEmployee = employeeService.getEmployeeById(id);

        newEmployee.setEmployeeName(employee.getEmployeeName());
        newEmployee.setPhoneNumber(employee.getPhoneNumber());
        newEmployee.setReportsTo(employee.getReportsTo());
        newEmployee.setProfileImage(employee.getProfileImage());

        employeeService.updateEmployeeById(newEmployee);
        return "Employee with id: '" + id + "' has been updated successfully";
    }

    @GetMapping("/nLevel/{id}/{n}")
    public String getNthLevelManager(@PathVariable String id,@PathVariable int n){
        Employee newEmployee = employeeService.getEmployeeById(id);
        Employee temp = null;
        String reportingManager = newEmployee.getReportsTo();

        for(int i=0;i<n;i++){
            temp =  employeeService.getEmployeeById(reportingManager);
            if(temp==null){
                return "The nth level Manager does not exist";
            }
            reportingManager = temp.getReportsTo();
        }
        if (temp == null) {
            return "The nth level Manager does not exist.";
        }

        return "The nth level Manager of Employee id: '" + newEmployee.getId() + "' is: " + temp.getEmployeeName();
    }

    @GetMapping("/employeesSorting")
    public List<Employee> findAllEmployees(@RequestParam(defaultValue = "1") int pageNumber,
                                           @RequestParam(defaultValue = "5") int pageSize,
                                           @RequestParam(defaultValue = "name") String sortBy){
        Page<Employee> employeePage = employeeService.getAllEmployees(pageNumber, pageSize, sortBy);
        return employeePage.getContent();
    }
}
