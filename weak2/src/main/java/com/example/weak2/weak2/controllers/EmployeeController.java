package com.example.weak2.weak2.controllers;


import com.example.weak2.weak2.Dto.EmployeeDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

//import java.util.Locale;
//HEre jackson help this JSOn convertion
@RestController
@RequestMapping("/employees")
public class EmployeeController {

//    @GetMapping("/message")
//    public String getMessage() {
//        return "This is a message";
//    }

    @GetMapping("/info")
    public String getData(@RequestParam Integer age, @RequestParam String sortBy, @RequestParam(required = false) Integer count) {
        return "Age is" + age + "Sort By" + sortBy + "Count" + count;
    }

    @GetMapping("/{empId}")
    public EmployeeDto getInfo(@PathVariable(name = "empId") String Id) {
        return new EmployeeDto(Id, "Abhik", "ab@gmail.com", 20, LocalDate.of(2024, 1, 2), true);
    }

}
