package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.service.UserService;

@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String greetUser() {
        return userService.getGreeting("Gautam Kumar");
    }

}
