package com.haina.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 在spring初始化的时候，回根据配置的路径进行扫描，扫描改路径下页就是这个包下的
 * 所有类，spring会检测改类知否会有Controler注解修饰，
 * 如果有，则会把改类的对象加载到spring容器中
 * @Controller 只能写在类上
 */
@Controller
public class IndexController {

    /**
     * spring检测到该类有controller注解修饰后，会继续检测该类中的方法是否有
     * Reques tMapping注解修饰，如果有，springmvc 会把注解内配置的urL
     * 注册到地址管理的容器中，以后就可以通过url找到对应的方法才
     * @return
     */
    @RequestMapping("abc")
    public String test(){
        //我们在springmvc . xmZ里面配置了视图的前綴和后缀，我们这return 里面只需要写上文件名即可
        //springmvc会自动的给我们补充上前缀和后缀，实际访问的路径是WEB-INF/views/index . jsp|
        //所以我们只需要协商jsp文件的名字即可，spring会自动的帮我们找到
       //重定向到另一个接口 redirect:write,地址栏会发生变化http://localhost:8080/springmvc_test2_war_exploded/write
        return "forward:write";//实现内部http接口的跳转，内部两个接口之间跳转
    }

//    这是一个二级路径
    @RequestMapping("abc/page")
    public String test1(){
        return "index";
    }

    //    该方法没有返回值，也不会跳转页面，我们要做的时访问改方法，然后方法直接在页面输出内容
    @RequestMapping("write")
    public void testWrite(HttpServletResponse response) throws IOException {
        response.getWriter().write("hello world");
    }
//    重定向地址栏会变化，请求转发地址栏不会变

//    value属性用来配置请求路径
//    method属性用来配置请求方法
//    当我们括号里面只有一个参数的时候，默认是value赋值，不需要显示的写value=
//    只有get的请求方式可以通过浏览器地址栏直接访问
    @RequestMapping(value="testGet",method = RequestMethod.GET)
    public String testMethod(){
        return "index";
    }

//    post请求方式，只能通过表单的形式访问，不能通过地址栏访问
    @RequestMapping(value="testPost",method = RequestMethod.POST)
    public String testPost(){
        return "index";
    }

}
