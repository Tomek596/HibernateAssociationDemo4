package com.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_training")
    private Integer idTtraining;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "employee_training", joinColumns = @JoinColumn(name = "id_training"), inverseJoinColumns = @JoinColumn(name = "id_employee"))
    private List<Employee> employees;

    public Training() {
    }

    public Training(String name) {
        this.name = name;
    }

    public Integer getIdTtraining() {
        return idTtraining;
    }

    public void setIdTtraining(Integer idTtraining) {
        this.idTtraining = idTtraining;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee){
        if(employees == null){
            employees = new ArrayList<>();
        }
        employees.add(employee);
    }
    @Override
    public String toString() {
        return "Training{" +
                "idTtraining=" + idTtraining +
                ", name='" + name + '\'' +
                '}';
    }
}
