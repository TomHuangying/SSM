package com.haina.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//name属性的作用，根据名称，把request 中对应的数据放到session中
//types作用， 根据类型，把对应类型的数据从request中放到session里， key保持与request中的key 一致

@SessionAttributes(names={"abc","def"},types=User.class)
@Controller
public class SessionController {

//    原始使用方式
    @RequestMapping("testSession1")
    public String testSession1(HttpServletRequest request)
    {
//        使用request对象来获取session
        HttpSession session = request.getSession();
        session.setAttribute("username","admin");

//        相同的key，先从最低作用域去找,从小到大分别pageContext,request,session,application
        request.setAttribute("username","request data");
        return "session1";
    }


//想要使用SessionAttributes注解的时候，方法参数 类型!不能是HttpServletRequest类型
//   只有model对象种的数据才会被赋值给session
    @RequestMapping("testSession2")
    public String testSession2(Model model)
    {
//        的用session域取值
        model.addAttribute("abc","springmvc session test");
        model.addAttribute("def","new data  ");
        User u = new User();
        u.setName("www");
        u.setPhone("131");
        model.addAttribute("user",u);
        return "session2";
    }
}
