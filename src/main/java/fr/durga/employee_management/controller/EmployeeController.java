package fr.durga.employee_management.controller;


import fr.durga.employee_management.APIResponse;
import fr.durga.employee_management.datamodel.Employee;
import fr.durga.employee_management.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getList(){
        List<Employee> employees = employeeService.listOfEmployees();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<APIResponse> createEmployee(@RequestBody Employee employee){

        employeeService.createEmployee(employee);
        return new ResponseEntity<>(new APIResponse(true,"employee added"),HttpStatus.CREATED);
    }
}