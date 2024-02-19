package fr.durga.employee_management.controller;


import fr.durga.employee_management.APIResponse;
import fr.durga.employee_management.datamodel.Employee;
import fr.durga.employee_management.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    //private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getList(){
        List<Employee> employees = employeeService.listOfEmployees();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<APIResponse> createEmployee(@RequestBody Employee employee){

        //logger.info("Received Employee Data: {}", employee.toString());
        System.out.println(employee);
        employeeService.createEmployee(employee);
        return new ResponseEntity<>(new APIResponse(true,"employee added"),HttpStatus.CREATED);
    }



    @DeleteMapping("{e_id}")
    public ResponseEntity<APIResponse> deleteEmployee(@PathVariable Integer e_id){


        Optional<Employee> employee = employeeService.findEmployeeById(e_id);
        if(employee.isPresent()) {

            System.out.println(employee);
            employeeService.deleteEmployee(e_id);

            return new ResponseEntity<>(new APIResponse(true, "employee deleted"), HttpStatus.OK);
        }

        return new ResponseEntity<>(new APIResponse(false,"employee not found"),HttpStatus.OK);
    }


}
