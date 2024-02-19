package fr.durga.employee_management.services;

import fr.durga.employee_management.datamodel.Employee;
import fr.durga.employee_management.repository.EmployeeRepository;
import org.hibernate.FetchNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService extends RuntimeException{

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> listOfEmployees(){
        return employeeRepository.findAll();
    }

    public void createEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteEmployee( Integer e_id){
        employeeRepository.deleteById(e_id);
    }

    public Optional<Employee> findEmployeeById(Integer e_id){

        Optional<Employee> employee = Optional.ofNullable(employeeRepository.findById(e_id).orElseThrow(() ->
                new ResourceNotFoundException("Employee not exist with id" + e_id)));

        return employee;

    }

    public void updateEmployee(int e_id){

    }
}
