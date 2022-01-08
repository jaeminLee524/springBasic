package com.example.springbasic.aop;

import com.example.springbasic.dto.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    // 컨트롤러 하위에 적용
    @Pointcut("execution(* com.example.springbasic.controller..*.*(..))")
    private void pointCut() {}

    // @Decode annotation을 가진 애들
    @Pointcut("@annotation(com.example.springbasic.aop.annotation.Decode)")
    private void enableDecode() {}

    @Before("pointCut() && enableDecode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            // User라는 객체일경우
            if( arg instanceof User) {
                User user = User.class.cast(arg);
                String base64Address = user.getAddress();

                //Decode 값
                String decodeAddress = new String(Base64.getDecoder().decode(base64Address), "UTF-8");
                user.setAddress(decodeAddress);
            }

        }

    }

    @AfterReturning(value = "pointCut() && enableDecode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        if(returnObj instanceof User) {
            User user = User.class.cast(returnObj);
            String address = user.getAddress();
            String encodeAddress = Base64.getEncoder().encodeToString(address.getBytes());
            user.setAddress(encodeAddress);

        }
    }

}
