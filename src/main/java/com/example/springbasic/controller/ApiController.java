package com.example.springbasic.controller;

import com.example.springbasic.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    // req -> object Mapper -> object
    // method
    // object -> object mapper -> json -> res
    @PostMapping("/json")
    public User json(User user) {
        return user;
    }

    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    /**
     *  validation
     */
    @PostMapping("user")
    public User user(@RequestBody User user) {
        System.out.println("user = " + user);

        return user;
    }
}
