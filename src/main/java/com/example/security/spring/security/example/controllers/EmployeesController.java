package com.example.security.spring.security.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeesController {

    @GetMapping("/home")
    public String home() {
        return "Welcome To Employee Data Set";
    }
}
