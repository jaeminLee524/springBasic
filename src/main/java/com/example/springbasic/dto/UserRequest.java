package com.example.springbasic.dto;

import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private String email;
    private int age;
}

