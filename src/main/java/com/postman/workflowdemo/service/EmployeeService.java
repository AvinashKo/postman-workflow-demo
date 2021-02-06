package com.postman.workflowdemo.service;

import com.postman.workflowdemo.Repository.EmployeeRepository;
import com.postman.workflowdemo.dto.AddEmployeeRequest;
import com.postman.workflowdemo.dto.GetAllEmployeeRecord;
import com.postman.workflowdemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public GetAllEmployeeRecord getAllEmployees() {
        GetAllEmployeeRecord allEmployeeRecord = new GetAllEmployeeRecord();
        allEmployeeRecord.setListOfEmployees(employeeRepository.findAll());
        return allEmployeeRecord;
    }

    public void addNewEmployee(AddEmployeeRequest addEmployeeRequest) {
        Employee employee = new Employee();
        employee.setFirstName(addEmployeeRequest.getFirstName());
        employee.setLastName(addEmployeeRequest.getLastName());
        employee.setAge(addEmployeeRequest.getAge());
        employee.setPhoneNumber(addEmployeeRequest.getPhoneNumber());
        employee.setRetired(addEmployeeRequest.isRetired());
        employeeRepository.save(employee);
    }

    public GetAllEmployeeRecord retireEmployee() {
        GetAllEmployeeRecord getAllEmployeeRecord = new GetAllEmployeeRecord();
        List<Employee> allEmployee = employeeRepository.findAll();
        List<Employee> employeesToRetire = new ArrayList<>();
        for (Employee employee : allEmployee) {
            if (employee.getAge() > 60) {
                employee.setRetired(true);
                employeesToRetire.add(employee);
            }
        }
        getAllEmployeeRecord.setListOfEmployees(employeeRepository.saveAll(employeesToRetire));
        return getAllEmployeeRecord;
    }

    public GetAllEmployeeRecord fetchAllRetiredEmployeesRecords() {
        GetAllEmployeeRecord getAllEmployeeRecord = new GetAllEmployeeRecord();

        return getAllEmployeeRecord;
    }
}
