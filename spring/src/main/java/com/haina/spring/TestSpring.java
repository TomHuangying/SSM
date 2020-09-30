package com.haina.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
//      传统创建对象的方式
//      HelloWorld helloWorld = new HelloWorld();
//      helloWorld.say();

//        创建spring全局对象，加载配置文件，用来初始化spring容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

//        调用getBean方法，使用xml中的bean的id来获取容器中的对象
        HelloWorld h = (HelloWorld)ctx.getBean("hello");//没有对msg赋值hello wordnull
//          通过类类型来或是对应的对象
//        容器中不能有两个或多个相同类型的对象
//        HelloWorld h2 = (HelloWorld)ctx.getBean(HelloWorld.class);
        h.say();
//        h2.say();
        HelloWorld h3 = (HelloWorld)ctx.getBean("hw");//hello wordxml msg

        h3.say();
//        做一个读取数据库的程序
        /**
         *
         */
        HelloWorld h4 = (HelloWorld)ctx.getBean("hw2");//hello wordxml msg
        h4.say();
        HelloWorld h5 = (HelloWorld)ctx.getBean("helloPerson");//hello wordxml msg
        h5.info();
        HelloWorld h6 = (HelloWorld)ctx.getBean("helloAuto");//hello wordxml msg
        h6.info();

        UserService us1 = ctx.getBean(UserService.class);
        us1.getUserName();//可以被调用，说明指向了一个对象
    }
}
