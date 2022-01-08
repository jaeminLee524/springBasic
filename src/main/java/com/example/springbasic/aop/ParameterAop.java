package com.example.springbasic.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParameterAop {

    // 동작순서 : before -> @PointCut method -> AfterReturning

    @Pointcut("execution(* com.example.springbasic.controller..*.*(..))")
    private void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) { //JoinPoint 들어가는 지점에 가지고 있는 객체
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("method = " + method.getName());

        Object[] args = joinPoint.getArgs();
        for( Object obj : args) {
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println(" value : " + obj);
        }
    }

    @AfterReturning(value = "pointCut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {
        System.out.println("return obj");
        System.out.println("returnObj = " + returnObj);
    }

}
