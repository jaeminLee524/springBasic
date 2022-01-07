package com.example.springbasic.controller;

import com.example.springbasic.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    // 변하는 정보를 받는 법
    @GetMapping("/path-variable/{name}")
    public String pathVariable(@PathVariable String name) {

        System.out.println("PathVariable = " + name);

        return name;
    }

    // 검색을 통해 받는 법 @RequestParam
    // 형태 : ?key=value&key2=value2
    // http://localhost:9090/api/get/query-param?name=jaemin&email=jaemin@gmail.com&age=27
    @GetMapping("/query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            sb.append(entry.getKey() + "=" + entry.getValue() + "\n");
        });

        return sb.toString();
    }


    // 객체로 받을때는 @queryParam 명시하지 않음
    // spring이 객체가 들어오면 queryParameter에 있는 주소 ?~~~~를 판단하여 key에 해당하는 객체와 매칭해줌
    @GetMapping("query-param2")
    public String queryParam03(UserRequest userRequest) {

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
