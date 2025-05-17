package com.example.EmployeeSpringProject.controllers;

import com.example.EmployeeSpringProject.models.Employee;
import com.example.EmployeeSpringProject.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService es;

    @GetMapping("/")
    public List<Employee> getAllEmployees(){
        return es.getAllEmployee();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return es.getEmployeeById(id);
    }
    @GetMapping("/byname/{name}")
    public Employee getEmployeename(@PathVariable String name){
        return es.getEmployeebyName(name);
    }
    @PostMapping("/")
    public void addNewEmployee(@RequestBody Employee emp){
        es.addEmployee(new Employee(emp.getEmpId(),emp.getEmpName(),emp.getDepartment()));
    }
    @PutMapping("/{id}")
    public void updateEmp(@PathVariable int id,@RequestBody Employee e){
        es.updateEmployee(id,new Employee(e.getEmpId(),e.getEmpName(),e.getDepartment()));
    }
    @DeleteMapping("/{id}")
    public void deleteemp(@PathVariable int id){
        es.deleteEmployee(id);
    }


}
