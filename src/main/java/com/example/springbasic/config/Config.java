package com.example.springbasic.config;

import com.example.springbasic.ioc.Base64Encoder;
import com.example.springbasic.ioc.Encoder;
import com.example.springbasic.ioc.UrlEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean("base64Encod")
    public Encoder encoder(Base64Encoder base64Encoder) {
        return new Encoder(base64Encoder);
    }

    @Bean("urlEncod")
    public Encoder encoder(UrlEncoder urlEncoder) {
        return new Encoder(urlEncoder);
    }
}
