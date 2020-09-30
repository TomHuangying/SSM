package com.haina.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.support.AopUtils;
import org.springframework.web.bind.annotation.PathVariable;

//aop类
public class AopAspect {
//    JoinPoint P一定要大写，p小写是另一个类
    public void before(JoinPoint joinPoint){
//        获取被代理得方法名
        String name = joinPoint.getSignature().getName();


//        用来获取被代理得方法参数值列表
        Object[] params = joinPoint.getArgs();

        for(Object o :params){
            Integer i = (Integer) o;
            if(i<0){
                throw new RuntimeException(name+"方法得参数不允许负数");
            }
        }
        System.out.println(name +"方法执行");
    }

    public void after(JoinPoint joinPoint){
        //        获取被代理得方法名
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"方法执行完成！！！");
    }

    public void afterRet(JoinPoint joinPoint,int result){
//        获取被代理得方法名
        String name = joinPoint.getSignature().getName();

        System.out.println(name+"方法执行成功"+",方法执行结果："+result);
    }

    public void afterException(JoinPoint joinPoint){
//        获取被代理得方法名
        String name = joinPoint.getSignature().getName();

        System.out.println(name+"方法抛出了异常");
    }

//    环绕通知，需要手动调用,环绕通知得方法根据被代理得方法来决定要不要加返回值
//    如果被代理得方法有返回值，则方法发必须也要加返回值
    public Object round(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        System.out.println("环绕通知");
//调用被代理得方法
        Object result = proceedingJoinPoint.proceed();

        System.out.println("环绕通知结束，运行结果："+result);
        return result;
    }
}
