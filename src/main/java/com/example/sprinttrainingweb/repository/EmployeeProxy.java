package com.example.sprinttrainingweb.repository;

import com.example.sprinttrainingweb.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class EmployeeProxy {

    @Autowired
    private CustomProperties props;

    /**
     * Get all employees
     *
     * @return An iterable of all employees
     */

    public Iterable<Employee> getEmployees() {
        props = new CustomProperties();  //TODO: remove until autowire works

        String baseApiUrl = props.getApiUrl();
        String getEmployeesUrl = baseApiUrl + "/employees";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Employee>> response = restTemplate.exchange(
                getEmployeesUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Employee>>() {
                }
        );

        //log.debug("Get Employees call " + response.getStatusCode().toString());  // Todo: implement when log works
        System.out.println("Get Employees call " + response.getStatusCode());

        return response.getBody();
    }

    /**
     * Get an employee by the id
     *
     * @param id The id of the employee
     * @return The employee which matches the id
     */
    public Employee getEmployee(int id) {
        String baseApiUrl = props.getApiUrl();
        String getEmployeeUrl = baseApiUrl + "/employee/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> response = restTemplate.exchange(
                getEmployeeUrl,
                HttpMethod.GET,
                null,
                Employee.class
        );

        System.out.println("Get Employee call " + response.getStatusCode().toString());

        return response.getBody();
    }

    public Employee createEmployee(Employee e) {
        String baseApiUrl = new CustomProperties().getApiUrl();
        String createEmployeeUrl = baseApiUrl + "/employee";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Employee> request = new HttpEntity<Employee>(e);
        ResponseEntity<Employee> response = restTemplate.exchange(
                createEmployeeUrl,
                HttpMethod.POST,
                request,
                Employee.class);

        System.out.println("Create Employee call " + response.getStatusCode().toString());
        return response.getBody();
    }

    public Employee updateEmployee(Employee employee) {
        props = new CustomProperties();
        String baseApiUrl = props.getApiUrl(); //TODO  propos autowire??
        String updateEmployeeUrl = baseApiUrl + "/employee/" + employee.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Employee> request = new HttpEntity<Employee>(employee);
        ResponseEntity<Employee> response = restTemplate.exchange(
                updateEmployeeUrl,
                HttpMethod.PUT,
                request,
                Employee.class);

        System.out.println("Update Employee call " + response.getStatusCode().toString());

        return response.getBody();
    }

    /**
     * Delete an employee using exchange method of RestTemplate
     * instead of delete method in order to log the response status code.
     *
     * @param e The employee to delete
     */
    public void deleteEmployee(int id) {
        props = new CustomProperties(); //TODO autowire dosn't works

        String baseApiUrl = props.getApiUrl();
        String deleteEmployeeUrl = baseApiUrl + "/employee/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(
                deleteEmployeeUrl,
                HttpMethod.DELETE,
                null,
                Void.class);

        System.out.println("Delete Employee call " + response.getStatusCode().toString());
    }


}
