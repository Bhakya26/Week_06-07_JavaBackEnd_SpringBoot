package com.example.EmployeeSpringProject.services;

import com.example.EmployeeSpringProject.models.Department;
import com.example.EmployeeSpringProject.models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> emplist = new ArrayList<>(
            List.of(
                    new Employee(1,"Bhagya",new Department("HR")),
                    new Employee(2,"Lakshmi",new Department("Sales"))

            )
    );

    public List<Employee> getAllEmployee(){
        return emplist;
    }
    public Employee getEmployeeById(int id){
        for(int i=0;i< emplist.size();i++){
            if(emplist.get(i).getEmpId() == id){
                return emplist.get(i);
            }
        }
        return null;
    }
    public Employee getEmployeebyName(String name){
        for(int i=0;i<emplist.size();i++){
            if(emplist.get(i).getEmpName().equalsIgnoreCase(name)){
                return emplist.get(i);
            }
        }
        return null;
    }

    public void addEmployee(Employee e){
        emplist.add(e);
    }
    public void updateEmployee(int id,Employee e){
        for(int i=0;i<emplist.size();i++){
            if(emplist.get(i).getEmpId()==id){
                emplist.set(i,e);
            }
        }
    }
    public void deleteEmployee(int id){
        for(int i=0;i<emplist.size();i++){
            if(emplist.get(i).getEmpId()==id){
                emplist.remove(emplist.get(i));
            }
        }
    }
}
