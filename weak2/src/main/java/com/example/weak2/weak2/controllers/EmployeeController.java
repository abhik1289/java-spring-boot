package com.example.weak2.weak2.controllers;


import com.example.weak2.weak2.Dto.EmployeeDto;
import com.example.weak2.weak2.Reposatory.EmployeeRepository;
import com.example.weak2.weak2.entity.EmployeeEntity;
import com.example.weak2.weak2.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//import java.util.Locale;
//HEre jackson help this JSOn convertion
@RestController
@RequestMapping("/employees")
public class EmployeeController {

//    @GetMapping("/message")
//    public String getMessage() {
//        return "This is a message";
//    }

//    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    public EmployeeController(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }

    @GetMapping()
    public List<EmployeeEntity> getAll() {
        return employeeService.findAllEmployee();
    }

    @GetMapping("/info")
    public List<EmployeeEntity> getData(@RequestParam Integer age, @RequestParam String sortBy, @RequestParam(required = false) Integer count) {
        return employeeRepository.findAll();
    }

    @GetMapping("/{empId}")
    public EmployeeEntity getInfo(@PathVariable(name = "empId") Long Id) {
        return employeeRepository.findById(Id).orElse(null);
    }

    @PostMapping("/add")
    public EmployeeEntity addData(@RequestBody EmployeeEntity input) {
        return employeeRepository.save(input);
    }

}
