package com.example.EmployeeSpringProject.models;


public class Department {
    private String departmentname;

    public Department(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentname='" + departmentname + '\'' +
                '}';
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }
}
