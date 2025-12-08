package com.example.demo.controller;
import com.example.demo.model.User;
import com.example.demo.service.RemoteUserService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test-api")
public class ApiTestController {

    private final RemoteUserService remoteUserService;

    public ApiTestController(RemoteUserService remoteUserService) {
        this.remoteUserService = remoteUserService;
    }

    @GetMapping("/users")
    public User[] getUsers() {
        return remoteUserService.getUsersJson();
    }

    @GetMapping("/user-names")
    public List<String> getUserNames() {
        User[] users = remoteUserService.getUsersJson();
        List<String> names = new ArrayList<>();
        for (User user : users) {
            names.add(user.getName());   // <-- .getName() accesses the name field
        }
        return names;
    }
}



