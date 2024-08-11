package com.employee_management_system.employee_management_system.services;

import com.employee_management_system.employee_management_system.Repository.EmployeeRepository;
import com.employee_management_system.employee_management_system.entity.EmployeeEntity;
import com.employee_management_system.employee_management_system.model.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    /*Constructor*/

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    /*Post mapping
    * Creating Save Employee Api*/
    @Override
    public Employee createEmployee(Employee employee) {
        /*To save in the database convert in entity*/
        /*To save new employee*/
        EmployeeEntity employeeEntity = new EmployeeEntity();
        /*It will copy all the property*/
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }


    /*Get Mapping*/
    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities
                = employeeRepository.findAll();
        /*to convert list of employeeEntity into employee*/
        /*Stream*/
        List<Employee> employees
                = employeeEntities
                .stream()
                .map(emp -> new Employee(
                        emp.getId(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmailId()))
                .collect(Collectors.toList());
        return employees;
    }


    /*Delete mapping*/
    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;
    }


    /*Edit Method*/
    @Override
    public Employee getEmployeeById(Long id) {
        EmployeeEntity employeeEntity= employeeRepository.findById(id).get();

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

//    put method
    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        EmployeeEntity employeeEntity =
                employeeRepository.findById(id).get();

        employeeEntity.setEmailId(employee.getEmailId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());

        employeeRepository.save(employeeEntity);

        return employee;
    }
}
