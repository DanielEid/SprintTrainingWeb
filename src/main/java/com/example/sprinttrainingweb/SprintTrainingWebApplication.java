package com.example.sprinttrainingweb;

import com.example.sprinttrainingweb.model.Employee;
import com.example.sprinttrainingweb.repository.CustomProperties;
import com.example.sprinttrainingweb.repository.EmployeeProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@Data
@SpringBootApplication
public class SprintTrainingWebApplication implements CommandLineRunner {

    @Autowired
    private CustomProperties properties;

    public static void main(String[] args) {
        SpringApplication.run(SprintTrainingWebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(properties.getApiUrl());

        //Tests//
        EmployeeProxy employeeProxy = new EmployeeProxy();
        employeeProxy.getEmployees();
        employeeProxy.createEmployee(new Employee());
    }
}
