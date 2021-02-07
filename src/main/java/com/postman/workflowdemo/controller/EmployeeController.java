package com.postman.workflowdemo.controller;

import com.postman.workflowdemo.dto.AddEmployeeRequest;
import com.postman.workflowdemo.dto.BaseResponseDTO;
import com.postman.workflowdemo.dto.GetAllEmployeeRecord;
import com.postman.workflowdemo.model.Employee;
import com.postman.workflowdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(
            value = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public BaseResponseDTO<GetAllEmployeeRecord> getAllEmployees() {
        BaseResponseDTO<GetAllEmployeeRecord> response = new BaseResponseDTO<>();
        response.setData(employeeService.getAllEmployees());
        return response;
    }

    @PostMapping(
            value = "/add",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public BaseResponseDTO<Employee> getArticleById(@RequestBody AddEmployeeRequest addEmployeeRequest) {
        BaseResponseDTO<Employee> response = new BaseResponseDTO<>();
        response.setData(employeeService.addNewEmployee(addEmployeeRequest));
        return response;
    }


    @DeleteMapping(
            value = "/retire",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public BaseResponseDTO<GetAllEmployeeRecord> retireEmployees() {
        BaseResponseDTO<GetAllEmployeeRecord> baseResponse = new BaseResponseDTO<>();
        baseResponse.setData(employeeService.retireEmployee());
        return baseResponse;
    }

    @GetMapping(
            value = "/all-retired",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public BaseResponseDTO<GetAllEmployeeRecord> getAllRetierdEmployees() {
        BaseResponseDTO<GetAllEmployeeRecord> response = new BaseResponseDTO<>();
        response.setData(employeeService.fetchAllRetiredEmployeesRecords());
        return response;
    }
}
