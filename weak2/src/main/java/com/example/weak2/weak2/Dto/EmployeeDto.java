package com.example.weak2.weak2.Dto;

import java.time.LocalDate;

public class EmployeeDto {

    private String id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate joiningDate;
    private Boolean isActive;

    public EmployeeDto() {

    }

    public EmployeeDto(String id, String name, String email, Integer age, LocalDate joiningDate, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.joiningDate = joiningDate;
        this.isActive = isActive;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getActive() {
        return isActive;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public String getEmail() {
        return email;
    }







}
