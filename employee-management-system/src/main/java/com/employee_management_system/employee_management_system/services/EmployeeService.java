package com.employee_management_system.employee_management_system.services;

import com.employee_management_system.employee_management_system.model.Employee;

import java.util.List;

public interface EmployeeService {
    /*Post Mapping*/
    Employee createEmployee(Employee employee);


    /*Get Mapping*/
    List<Employee> getAllEmployees();

    boolean deleteEmployee(Long id);

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);
}
