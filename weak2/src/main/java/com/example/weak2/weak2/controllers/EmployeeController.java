package com.example.weak2.weak2.controllers;


import com.example.weak2.weak2.Dto.EmployeeDto;
import com.example.weak2.weak2.Reposatory.EmployeeRepository;
import com.example.weak2.weak2.entity.EmployeeEntity;
import com.example.weak2.weak2.exceptions.ResourcesNotFoundExceptions;
import com.example.weak2.weak2.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

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

//    @GetMapping()
//    public List<EmployeeEntity> getAll() {
//        return employeeService.findAllEmployee();
//    }

    @GetMapping("/info")
    public List<EmployeeDto> getData(@RequestParam Integer age,
                                     @RequestParam String sortBy,
                                     @RequestParam(required = false) Integer count
    ) {
        return employeeService.findAll();
    }

    @GetMapping("/{empId}")
    public ResponseEntity<EmployeeDto> getInfo(@PathVariable(name = "empId") Long Id) {
        Optional<EmployeeDto> employeeDto = employeeService.findById(Id);
        return employeeDto.map(EDTO -> ResponseEntity.ok(EDTO)).orElseThrow(() -> new ResourcesNotFoundExceptions("Employee not found"));

    }

//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<String> handleExceptionNotFound(NoSuchElementException exception) {
//        return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
//    }

    @PostMapping("/add")
    public EmployeeDto addData(@RequestBody @Valid EmployeeDto input) {
        return employeeService.save(input);
    }

    @PutMapping
    public EmployeeDto updateEmpById(@RequestBody EmployeeDto employeeDto, @PathVariable Long empId) {
        return employeeService.updateEmployeeById(employeeDto, empId);
    }

    @DeleteMapping
    public boolean deleteEmployeeById(@PathVariable Long empId) {
        return employeeService.deleteEmployee(empId);
    }

    @PatchMapping(path = "/employeeId")
    public EmployeeDto partialUpdateEmplyee(@RequestBody Map<String, Object> updates, @PathVariable Long employeeId) {
        return employeeService.updatepartialEmpById(employeeId, updates);
    }

}
