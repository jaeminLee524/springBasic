//package com.example.springbasic.controller;
//
//import com.example.springbasic.dto.PutRequestDto;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api")
//public class PutApiController {
//
//    @PutMapping("/put")
//    public PutRequestDto put(@RequestBody PutRequestDto putRequestDto) {
//        System.out.println(putRequestDto);
//        //@RestController는 object를 objectMapper를 통해 json으로 바꿔줌
//        return putRequestDto;
//    }
//}
