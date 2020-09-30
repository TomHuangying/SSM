package com.haina.spring;

import org.springframework.stereotype.Repository;

@Repository//翻译:仓库
public class UserDao implements Dao{

    public void queryUser(){
        System.out.println("userDao.queryUser()");
    }
}
