package com.haina.spring.aop;

import org.springframework.stereotype.Component;

@Component //
public class CalculatorImpl implements Calculator {
    public int add(int a, int b) {
//        System.out.println("add方法被调用了");
//        if(a<0 || b<0){
//            throw new RuntimeException("方法只支持正数");
//        }
        return a+b;
    }

    public int sub(int a, int b) {
//        System.out.println("sub 方法被调用了");
        return a-b;
    }

    public int mul(int a, int b) {
//        System.out.println("mul 方法被调用了");
        return a*b;
    }

    public int div(int a, int b) {
//        System.out.println("div 方法被调用了");
        return a/b;
    }

    public void saveUser() {
        System.out.println("无参的save方法");
    }

    public void saveUser(int a) {
        System.out.println("一个参数的save方法");
    }

    public void saveUser(int a, String b) {
        System.out.println("两个参数的save方法");
    }
}
