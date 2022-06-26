package com.EmployeeManagementSystem.SpringProject.repository;

import com.EmployeeManagementSystem.SpringProject.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
