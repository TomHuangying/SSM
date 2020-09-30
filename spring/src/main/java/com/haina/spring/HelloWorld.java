package com.haina.spring;

public class HelloWorld {

    private String msg;

    private Person p;
    //构造器注入
    public HelloWorld(String msg){
        this.msg = msg;
    }
    public HelloWorld(){
    }
    public HelloWorld(String a,String b){
        System.out.println(a+b);
    }
    public void say(){
        System.out.println("hello word"+msg);
    }
    public void info(){
        System.out.println(p.getName());
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setP(Person p) {
        this.p = p;
    }
}
