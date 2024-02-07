package fr.durga.employee_management.services;

import fr.durga.employee_management.datamodel.Employee;
import fr.durga.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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

    public void deleteEmployee(@RequestBody int e_id){
        employeeRepository.deleteById(e_id);
    }

    public void updateEmployee(int e_id){

    }
}
