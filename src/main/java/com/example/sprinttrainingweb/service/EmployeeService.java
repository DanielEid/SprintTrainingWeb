package com.example.sprinttrainingweb.service;

import com.example.sprinttrainingweb.model.Employee;
import com.example.sprinttrainingweb.repository.EmployeeProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class EmployeeService {
    @Autowired
    private EmployeeProxy employeeProxy;

   public Employee getEmployee(final int id) { //My tmp fix //TODO: dosn't works? why?  what anotation I forgot again?
       //return employeeProxy.getEmployee(id);
       return new EmployeeProxy().getEmployee(id);
   }

    public Iterable<Employee> getEmployees() {
        //return employeeProxy.getEmployees();  //Why autowire employeeProxy doesn't work???
        return new EmployeeProxy().getEmployees();
    }

    public void deleteEmployee(final int id) {
        //employeeProxy.deleteEmployee(id);
        new EmployeeProxy().deleteEmployee(id);
    }

    public Employee saveEmployee(Employee employee) {
        Employee savedEmployee;

        // Règle de gestion : Le nom de famille doit être mis en majuscule.
        employee.setLastName(employee.getLastName().toUpperCase());

        if (employee.getId() == null) {
            // Si l'id est nul, alors c'est un nouvel employé.
            savedEmployee = new EmployeeProxy().createEmployee(employee);
        } else {
            savedEmployee = new EmployeeProxy().updateEmployee(employee);
        }

        return savedEmployee;
    }
}
