package fr.durga.employee_management.datamodel;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int e_id;
    @Column
    private String e_name;
    @Column
    private String e_role;
    @Column
    private float salary;
    @Column
    private String email;

    public Employee() {

    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_role() {
        return e_role;
    }

    public void setE_role(String e_role) {
        this.e_role = e_role;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee(int e_id, String e_name, String e_role, float salary, String email) {
        this.e_id = e_id;
        this.e_name = e_name;
        this.e_role = e_role;
        this.salary = salary;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "e_id=" + e_id +
                ", e_name='" + e_name + '\'' +
                ", e_role='" + e_role + '\'' +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                '}';
    }
}
