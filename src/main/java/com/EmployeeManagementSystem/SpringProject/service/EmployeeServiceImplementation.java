package com.EmployeeManagementSystem.SpringProject.service;

import com.EmployeeManagementSystem.SpringProject.models.Employee;
import com.EmployeeManagementSystem.SpringProject.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService{
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByid(int id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    @Override
    public Employee updateEmployee(Employee employee, int id) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow();

        existingEmployee.setName(employee.getName());
        existingEmployee.setAddress(employee.getAddress());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhonenumber(employee.getPhonenumber());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setRole(employee.getRole());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.findById(id).orElseThrow();
        employeeRepository.deleteById(id);
    }
}
