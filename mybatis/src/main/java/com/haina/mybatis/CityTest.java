package com.haina.mybatis;

import com.haina.mybatis.dao.CityDao;
import com.haina.mybatis.model.City;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class CityTest {
    public static void main(String[] args) throws Exception{
        String resource = "mybatis-config.xml";
        //加载mybatis核心配置文件到内存中
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //通过核心配置文件，创建出sessionFactory，用于创建连接使用的
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //使用连接工厂，创建出一个数据库的连接，用来操作数据库使用
        SqlSession session = sqlSessionFactory.openSession();

        CityDao cityDao = session.getMapper(CityDao.class);
        City city = cityDao.getCityById1(1);
        System.out.println(city.getName()+","+city.getCountry().getName());


        City cc = cityDao.getCityById2(1);
        System.out.println(cc.getName()+","+cc.getCountry().getName());

    }
}
