package com.haina.mybatis;

import com.haina.mybatis.dao.UserDao;
import com.haina.mybatis.model.User;
import javafx.util.Builder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        //加载mybatis核心配置文件到内存中
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //通过核心配置文件，创建出sessionFactory，用于创建连接使用的
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //使用连接工厂，创建出一个数据库的连接，用来操作数据库使用
        SqlSession session = sqlSessionFactory.openSession();

//      用来测试两个session间是否会公用缓存
        SqlSession s1 = sqlSessionFactory.openSession();

        //UserDao接口的实现类是mybatis给我们生成的，所以我们通过mybatis来获取接口的实现类
        UserDao userDao = session.getMapper(UserDao.class);

        User user = userDao.selectById(5);

        userDao.selectByNameAndAge2("zhangsan",22);

        //否则修改不会生效，提交事物
        session.commit();

//        在两次查询之间加上修改的操作，看是否会影响缓存的使用
//        修改操作会是数据库发上面换，缓存中的数据可能会错误，所以下面的查询会走数据库，不走缓存
//        userDao.updateUser(user);


//      清空缓存，子还行这个方法会清空缓存，后面的查询需要从新走数据库
//        session.clearCache();

        //再次查询id=5查询，控制台值输出了一条sql语句，说明了，在次执行相同的查询，会走缓存
//        User u =userDao.selectById(5);

//      使用新session获取dao对象，用来测试两个session的缓存问题
//        一级缓存事实证明多个session之间不会共享缓存
//        二级缓存在使用的时候，需要等其他会话已经执行完毕才能读取缓存，否则缓存中是没有数据的
        UserDao ud = s1.getMapper(UserDao.class);
        User u2 = ud.selectById(5);

        User u3 = ud.selectByName("zhangsan");
        System.out.println(user.getName());
        System.out.println(user.getFirstName());

        user.setName("zhangsan");
        //执行修改的方法
//        userDao.updateUser(user);


        //创建一个user对象
        User u1 = new User();
        u1.setName("abc");
        u1.setAge(22);
        u1.setFirstName("a");
//        将刚创建号的对象，插入到数据库中
//        userDao.insertUser(u1);

//        通过id来删除数据
//        userDao.deleteUser(7);


    }
}

