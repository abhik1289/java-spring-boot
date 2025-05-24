package com.example.weak2.weak2.Dto;

import com.example.weak2.weak2.annotations.EmployeeAnnotations;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class EmployeeDto {

    private Long id;

    @NotEmpty(message = "Name should be not null")
    @NotBlank(message = "It should be not blank")
    private String name;

    @Email
    private String email;

    @Size(min = 18, max = 80, message = "Your age is in between of 18 to 80")
    private Integer age;

//    @Pattern(regexp = "^(ADMIN|USER)$", message = "Your role should be ADMIN or USER")
    @EmployeeAnnotations
    private String role;

    @NotNull
    @PositiveOrZero()
    @Digits(integer = 5, fraction = 2)
    @DecimalMin(value = "10000.0")
    @DecimalMax(value = "89000")
    private Number salary;


    @Past
    private LocalDate joiningDate;

    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    //It tells Jackson (the library used by
    // frameworks like Spring Boot for JSON mapping)
    // to bind the isActive field in JSON to the isActive field in the Java class
    // even though the Java field is named isActive and not active
    private Boolean isActive;

    public EmployeeDto() {

    }

    public EmployeeDto(Long id, String name, String email, Integer age, LocalDate joiningDate, Boolean isActive) {
        this.id = id;

        this.name = name;
        this.email = email;
        this.age = age;
        this.joiningDate = joiningDate;

        this.isActive = isActive;
    }


}
