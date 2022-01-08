package com.example.springbasic.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeleteController {

    // delete -> 리소스 삭제 : 항상 Status 200 OK
    // 데이터가 있어서 삭제한 상태값 or 이미 삭제를해서 없는데 다시 삭제 요청 멱등하게 항상 200 OK를 던져줌
    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable Long userId, @RequestParam String account) {
        System.out.println("userId = " + userId + ", account = " + account);
    }
}
