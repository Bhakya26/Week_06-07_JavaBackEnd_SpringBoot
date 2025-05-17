package com.example.demo.Service;

import com.example.demo.Model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee createEmployee(Employee emp);
    Employee updateEmployee(Long id, Employee emp);
    void deleteEmployee(Long id);

}
