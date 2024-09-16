package com.sms.employeemanagementsystem.service;

import com.sms.employeemanagementsystem.entity.Employee;

import java.util.List;

public interface EmployeeService {


    List<Employee> getAllEmployee();
    Employee saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    Employee updateEmployeeDetails(Long id, Employee employee);
    void deleteEmployee(Long id);


}
