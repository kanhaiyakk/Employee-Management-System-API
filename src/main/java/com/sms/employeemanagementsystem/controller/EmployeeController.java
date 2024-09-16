package com.sms.employeemanagementsystem.controller;

import com.sms.employeemanagementsystem.service.EmployeeService;
import com.sms.employeemanagementsystem.entity.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("employees")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping("employee")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
    }


    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("employee")
    public void deleteEmployee(@RequestParam Long id){
        employeeService.deleteEmployee(id);
    }

    @PutMapping("employee/{id}")
    public ResponseEntity<Employee> updateEmployeeDetails(@PathVariable Long id, @RequestBody Employee employee){
         Employee updateEmployee = employeeService.updateEmployeeDetails(id, employee);
        if (updateEmployee != null) {
            return ResponseEntity.ok(updateEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
