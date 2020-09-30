package com.haina.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

//用来测试参数请求接收的controller
@Controller
public class ParamController {

    @RequestMapping("param")
    public String param(){
        return "param";
    }

    /**
     * 使用最原始的方式来接收请求
     * HttpServletRequest request
     * request.getParameter("name");
     * @param request
     * @return
     */
    @RequestMapping("testParam1")
    public String testParam1(HttpServletRequest request){
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println(name);
        System.out.println(age);
        return "param";
    }

    /**
     *http://localhost:8080/springmvc_test2_war_exploded/testParam2?id=123
     * 采用？形式传递参数，要求地址栏中的参数名完全一直，数据类型也要完全一致
     * @param id
     * @return
     */

    @RequestMapping("testParam2")
    public String testParam2(int id){

        System.out.println(id);
        return "param";
    }


    @RequestMapping("testParam3")
    public String testParam3(int id,String name){

        System.out.println(id);
        System.out.println(name);
        return "param";
    }

    /**
     * 当方法的参数是基本类型和String之外的类型时
     * springmvc回自动把地址栏中的此参数赋值给对象的属性
     * 但是要求地址栏中的参数名必须和对象的属性名完全相同
     * @param user
     * @return
     */
    @RequestMapping("testParam4")
    public String testParam4(User user,int age){
        System.out.println(user.getPhone());
        System.out.println(user.getAddress());
        System.out.println(age);
        return "param";
    }

    //当浏览器地址栏参数与方法参数不一致的时候，可以使用RequestParam注解来转换
    //这样写的意思就是从地址栏接收一个叫做n的参数，然后赋值给name 参数
    //在地址栏中，n代替了name    testParam5?n=zzzz
    @RequestMapping("testParam5")
    public String testParam5(@RequestParam("n") String name){
        System.out.println(name);
        return "param";
    }

//    使用路径进行传参
//    http://localhost:8080/springmvc_test2_war_exploded/testParam5/1234/abcd

    /**
     * 接收参数的时候，需要在RequestMapping的配置中增加一个占位符，然后在方法参数前加上
     * PathVariable注解，注解内的值要与占位符的值一致
     * 相对路径，多点几次会累加（报错404），所以将项目名变成绝对路径就可以
     * <a href="/springmvc_test2_war_exploded/testParam6/1234">第六种参数接收方式</a>  <br/>
     * @param id
     * @return
     */
    @RequestMapping("testParam6/{id}")
    public String testParam6(@PathVariable("id") int id ){
        System.out.println(id);
        return "param";
    }

//    多个参数的接收
    @RequestMapping("testParam7/{id}/{name}")
    public String testParam7(@PathVariable("id") int id , @PathVariable("name") String name){
        System.out.println(id);
        System.out.println(name);
        return "param";
    }


}
