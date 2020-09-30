package com.haina.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
//aop切面类的执行顺序默认是bean加载的顺序，spring扫描类的时候，会默认使用文件名进行排序，先扫描到的优先加载的容器中
//为了让我们可以自定义aop切面执行的顺序，我们可以使用order注解来调有
@Order(3) //调节各个类之间的优先级，值越小优先级越高，别的没写他写了，就是他最小，先加载到spring容器里面
public class AopAspect2 {


    @Pointcut("execution(public * com.haina.spring.aop.CalculatorImpl.saveUser())")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("AopAspect2 before-----------");
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("AopAspect2 after-----------");
    }
}
