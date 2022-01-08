package com.example.springbasic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class) // 해당클래스를 snakeCase로 인식하도록
public class PutRequestDto {

    private String name;
    private int age;
    private List<CarDto> carList;
}
