package com.example.springbasic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
public class PostRequestDto {

    private String account;
    private String email;
    private String address;
    private String password;

    //snack 요청을 파싱하기 위한 애노테이션
    @JsonProperty("phone_number")
    private String phoneNumber;
}
