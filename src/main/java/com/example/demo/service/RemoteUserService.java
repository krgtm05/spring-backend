package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RemoteUserService {

    private final WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com");

    public User[] getUsersJson() {
        return webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToMono(User[].class)
                .block();
    }
}
