package com.example.springbasic.controller;

import com.example.springbasic.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData) {
        requestData.forEach((k,v) -> {
            System.out.println("key = " + k);
            System.out.println("value = " + v);
        });
    }

    @PostMapping("/post/obj")
    public void post2(@RequestBody PostRequestDto requestData) {
        System.out.println("Account = " + requestData.getAccount());
    }
}
