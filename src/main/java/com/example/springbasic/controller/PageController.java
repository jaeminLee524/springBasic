package com.example.springbasic.controller;

import com.example.springbasic.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @ResponseBody // html 리소스를 찾는것이 아님, Controller에서 json으로  +                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         --------------------------------------------------ccccc 내려줄 수 있음
    @GetMapping("/user")
    public User user() {
//        User user = new User();
        // 타입추론
        var user = new User();
        user.setName("jaemin");
        user.setAddress("seoul");

        return user;
    }
}
