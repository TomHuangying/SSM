package com.haina.spring;

import org.springframework.stereotype.Repository;

@Repository
public class UserOracleDao implements Dao {

    public void queryUser(){
        System.out.println("UserOracleDao.queryUser()");
    }

}
