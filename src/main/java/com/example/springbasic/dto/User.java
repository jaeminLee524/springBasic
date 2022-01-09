package com.example.springbasic.dto;

import com.example.springbasic.aop.annotation.YearMonth;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class )
public class User {

    @NotBlank
    private String name;
    private int age;
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식과 맞지 않습니다. 01x-xxx(x)-xxxx")
    private String phoneNumber;
    private String address;
    @Email
    private String email;
    @YearMonth
    private String reqYearMonth;
}
