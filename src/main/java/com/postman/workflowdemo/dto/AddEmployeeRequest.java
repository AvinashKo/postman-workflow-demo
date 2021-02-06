package com.postman.workflowdemo.dto;

import lombok.Data;

@Data
public class AddEmployeeRequest {

    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
    private int salary;
    private boolean retired;
}
