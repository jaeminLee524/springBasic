package com.example.springbasic.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class Encoder implements IEncoder{

    private IEncoder iEncoder;

    // 매번 클래스의 코드 바꾸는건 비효율적, 본질에 맞지 않음
    //base64Encoder, urlEncoder중 우선순위를 부여함
    public Encoder(@Qualifier("urlEncoder") IEncoder iEncoder) { //Base64, UrlEncoder
        this.iEncoder = iEncoder;
    }

    public String encode(String message) {
        return iEncoder.encode(message);
    }
}
