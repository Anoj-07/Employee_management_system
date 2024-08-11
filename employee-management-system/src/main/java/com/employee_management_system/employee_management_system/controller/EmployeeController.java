package com.employee_management_system.employee_management_system.controller;

import com.employee_management_system.employee_management_system.model.Employee;
import com.employee_management_system.employee_management_system.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    /*Employee Service*/
    private final EmployeeService employeeService;


    /* Constructor*/
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    /*Method
    * Creating Save Employee API*/
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
      return  employeeService.createEmployee(employee);
    }


    /*Get All Employee data API*/
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }


    /*Delete data API*/
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        boolean deleted = false;
        deleted = employeeService.deleteEmployee(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", deleted);
        return ResponseEntity.ok(response);
    }

    /*Edit dat API*/
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = null;
        employee=employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }


    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){

        employee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(employee);
    }

}
