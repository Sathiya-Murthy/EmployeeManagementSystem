package com.EmployeeManagementSystem.SpringProject.controller;

import com.EmployeeManagementSystem.SpringProject.models.Employee;
import com.EmployeeManagementSystem.SpringProject.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping("/add")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public List<Employee> getAllEmployee(){
        return (employeeService.getAllEmployee());
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeByid(@PathVariable int id){
        return new ResponseEntity<Employee>(employeeService.getEmployeeByid(id),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee ,@PathVariable int id){
        return new  ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);
    }
    @DeleteMapping("/delete{id}")
    @PreAuthorize("hasRole('MANAGER')")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<String >("Employee data deleted",HttpStatus.OK);
    }
}
