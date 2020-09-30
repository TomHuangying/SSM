package com.haina.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//用注解写aop
@Aspect
@Component
public class AopAspect1 {

    @Pointcut("execution(public * com.haina.spring.aop.CalculatorImpl.*(..))")
    public void pointCut(){

    }

//    @Before("execution(public* com.haina.spring.aop.CalculatorImpl.*(..))")
//    这里可以符用表达式，注解里面得内容时带有@Pointcut注解得方法得方法名
    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法被执行------");
    }

//    @After("execution(public* com.haina.spring.aop.CalculatorImpl.*(..))")
    @After("pointCut()")
    public void after(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法执行完成------");
    }
}
