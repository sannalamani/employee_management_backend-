package fr.durga.employee_management.services;

import fr.durga.employee_management.datamodel.Employee;
import fr.durga.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> listOfEmployees(){
        return employeeRepository.findAll();
    }

    public void createEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Employee employee){
        employeeRepository.delete(employee);
    }

    public void updateEmployee(int e_id){

    }
}
