package com.haina.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    public static void main(String[] args) {
        //        创建spring全局对象，加载配置文件，用来初始化spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//       通过接口类型也可以获取到他实现类得对象
//        如果改接口有多个实现类，则不能这样写
        Calculator c = ctx.getBean(Calculator.class);

        int result = c.add(3,5);
        System.out.println(result);
        c.saveUser();
        c.saveUser(3);
//        c.div(2,1);
//        c.mul(3,5);
//        c.sub(6,4);
    }
}
