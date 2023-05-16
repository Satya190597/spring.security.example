package com.example.security.spring.security.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeesController {

    @GetMapping("/home")
    public String home() {
        return "Home Page";
    }
    @GetMapping("/user")
    public String userPage() {
        return "Welcome To User Page";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "Welcome To Admin Page";
    }
}
