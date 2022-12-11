package com.example.sprinttrainingweb.model;

import lombok.Data;

@Data
public class Employee {

    private Integer id;

    private String firstName;

    private String lastName;

    private String mail;

    private String password;


    //TODO: REMOVE getters & setters why autowire don't works???

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
