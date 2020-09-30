package com.haina.spring.aop;

//接口提供计算得功能
public interface Calculator {

    int add(int a,int b);

    int sub(int a,int b);

    int mul(int a,int b);

    int div(int a,int b);

    void saveUser();

    void saveUser(int a);

    void saveUser(int a,String b);
}
