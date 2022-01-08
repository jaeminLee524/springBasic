package com.example.springbasic;

import com.example.springbasic.ioc.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBasicApplication {

    public static void main(String[] args) {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";

        // 요구사항: Base 64 encoding
/*        Encoder encoder = new Encoder();
        IEncoder encoder = new Encoder();
        String result = encoder.encode(url);
        System.out.println("result = " + result);

        // 요구사항2: Base 64 -> url Encoding으로 변경
        UrlEncoder urlEncoder = new UrlEncoder();
        IEncoder urlEncoder = new UrlEncoder();
        String urlResult = urlEncoder.encode(url);
        System.out.println("urlResult = " + urlResult);*/

        // 2 DI주입
        /*Encoder eEncoder = new Encoder(new Base64Encoder());
        String encode = eEncoder.encode(url);
        System.out.println("encode = " + encode);*/


        // IOC Container에 등록된 빈을 갖고와서 작업
        SpringApplication.run(SpringBasicApplication.class, args);
        ApplicationContext context = ApplicationContextProvider.getContext();

        Encoder encoder = context.getBean("urlEncod", Encoder.class);
        String result = encoder.encode(url);
        System.out.println("result = " + result);
    }

}


