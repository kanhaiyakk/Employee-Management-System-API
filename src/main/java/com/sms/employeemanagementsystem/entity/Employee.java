package com.sms.employeemanagementsystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Employee First Name must not be null")
    @Size(min = 3, message = "Employee name must be atleast three characters")
    private String firstName;
    @NotBlank(message = "Employee Last Name must not be null")
    private String lastName;

    @NotBlank(message = "Email must not be null")
    private String email;
    @NotNull(message = "phoneNumber must not be null")
    private String phoneNumber;
    @NotNull(message = "Salary must not be null")
    private BigDecimal salary;
    @NotBlank(message = "Job Title must not be null")
    private String jobTitle;
    @NotBlank(message = "Department must not be null")
    private String department;
    @NotBlank(message = "Address must not be null")
    private String address;
}
