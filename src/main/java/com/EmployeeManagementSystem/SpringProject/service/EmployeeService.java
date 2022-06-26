package com.EmployeeManagementSystem.SpringProject.service;

import com.EmployeeManagementSystem.SpringProject.models.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeByid(int id);
    Employee updateEmployee(Employee employee,int id);
    void deleteEmployee(int id);
}
