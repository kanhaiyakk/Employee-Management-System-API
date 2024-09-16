package com.sms.employeemanagementsystem.serviceImpl;

import com.sms.employeemanagementsystem.entity.Employee;
import com.sms.employeemanagementsystem.exceptions.ResourceNotFoundException;
import com.sms.employeemanagementsystem.repository.EmployeeRepository;
import com.sms.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee=employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        throw new ResourceNotFoundException("Employee is not found for the id "+ id);

    }

    @Override
    public Employee updateEmployeeDetails(Long id, Employee employee) {

        Employee existingEmployee = getEmployeeById(id);
        existingEmployee.setFirstName(employee.getFirstName() != null ? employee.getFirstName() : existingEmployee.getFirstName());
        existingEmployee.setLastName(employee.getLastName() != null ? employee.getLastName() : existingEmployee.getLastName());
        existingEmployee.setEmail(employee.getEmail() != null ? employee.getEmail() : existingEmployee.getEmail());
        existingEmployee.setPhoneNumber(employee.getPhoneNumber() != null ? employee.getPhoneNumber() : existingEmployee.getPhoneNumber());
        existingEmployee.setJobTitle(employee.getJobTitle() != null ? employee.getJobTitle() : existingEmployee.getJobTitle());
        existingEmployee.setDepartment(employee.getDepartment() != null ? employee.getDepartment() : existingEmployee.getDepartment());
        existingEmployee.setAddress(employee.getAddress() != null ? employee.getAddress() : existingEmployee.getAddress());
        existingEmployee.setSalary(employee.getSalary() != null ? employee.getSalary() : existingEmployee.getSalary());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
