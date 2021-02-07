package com.postman.workflowdemo.dto;

import com.postman.workflowdemo.model.Employee;
import lombok.Data;

import java.util.List;

@Data
public class GetAllEmployeeRecord {

    private List<Employee> listOfEmployees;
}
