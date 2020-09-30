package com.haina.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

// 给类加上注解，spring初始化的时候，会扫描对应的包，检测这个包下所有带有特定
//注解的类，spring会对这些类进行管理，对列进行实例化
//相当于在xml中写了一个bean，创建UserService对象
//service标注的类，会自动的给该类创建一个bean, 然后命名的格式就是该类的类名，首字母小写
//我们也可以给该类自定义bean的id, 方(@Service("Us")， 这样写us就是该bean的id 1

@Service
//@Component
//@Repository
public class UserService {
// 注入值
//    value注解的作用就是把注解内的值赋到属性上
//  @value 从配置文件中读取数据然后赋值给属性
//    读取配置文件中的数据的方式，使用${}大括号里面写对应数据的名称
    @Value("${dbusername}")
    private String str;

    //Autowired注解根据类型自动匹配，如果没有该类型对象，会找该类型的子类对象或者实现类对象
//    在使用Autowired的时候，需要注意，当一个类型哟多个bean的时候，默认情况下会报错
//    要是有多个bean用Qualifier指定
    @Autowired //使用类型进行自动装配，找到对应的对象
    @Qualifier("userOracleDao")//两个类都继承实现dao，手动选择
    private Dao dao;

    //Resource 注解默认根据名称来查找对应的bean， 名称默认是属性的名字，如果通过属性的名字在容器中找到J
    //对应的bean, 则会注入成功，如果找不到，则会降级为根据类型来匹配，如果根据类型匹配可以找到唯- -的一 个
    //bean, 则同样可以注入成功，如果找到了多个则会报错，需要我们进一 步的处理

    @Resource//用的多
    private Dao userDao;//userDao.queryUser(),Resource注解默认的属性，根据名称查找，UserDao 默认是这个属性名

    @Resource(name="userDao",type = UserDao.class)//该注解还可以直接指定type, type 的值是class类型的，如果指定了type,则只能通过类型查找
    //如果name和type同时存在，则会根据两者找到唯- -匹配的那个对象，找不到则会报键
    private Dao p;//名字不是类名，Dao下面有多个实现类，可以用resource里面指定那个类

    @Resource
    private Date date;//jdk自带的日期类
    public void getUserName(){
        System.out.println("abcde"+str);
        System.out.println(date);
        dao.queryUser();
        userDao.queryUser();
        p.queryUser();
    }
}
