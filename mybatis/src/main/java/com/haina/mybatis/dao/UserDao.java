package com.haina.mybatis.dao;

import com.haina.mybatis.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    User selectById(int id);
    void updateUser(User user);
    void insertUser(User user);
    void deleteUser(int id);

//    采用注解的形式给方法添加实现
    @Select("select*from user where name=#{name}")
    User selectByName(String name);

    User selectByNameAndAge(String name,int age);

    User selectByNameAndAge2(@Param("name") String name, @Param("age")int age);
}

