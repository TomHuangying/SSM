package com.haina.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

//    用来测试给页面返回 数据的类
@Controller
public class ResponseController {
    @RequestMapping("testResp1")
    public String testResp1(HttpServletRequest request){
//        使用原始的方式给页面返回数据
        request.setAttribute("username","test");
        return "resp1";
    }

    /*
Model是接口类型，作为参数可以限制该方法传递的参数类型为该接口的实现类类型
springmvc在调用testResp2，就只能传递Model类的实现类类型的对象
*/
    @RequestMapping("testResp2")
    public String testResp2(Model model){
//        使用model参数传入的数据，仍然位于requestScope种
        model.addAttribute("name","abc");

        User u = new User();
        u.setName("ddd");
        u.setPhone("1234");
//        传递引用类型的数据给页面
        model.addAttribute("user",u);
        return "resp2";
    }



//    使用map类型参数也可以进行数据传递，原理与上面两种相同
    @RequestMapping("testResp3")
    public String testResp3(Map<String ,Object> map){
        map.put("name","map param");
//        先放map里，在向request里面放
        return "resp3";
    }

    //springmvc调用了 该方法之后，会收到一个ModeLAndView类型的返回值,
// springmvc 会把该对象里面的数据取出来，放到request 中
    @RequestMapping("testResp4")
    public ModelAndView testResp4(){
        ModelAndView mv = new ModelAndView();
//        调用addObject方法，给页面传递数据，可以传递字符串，也可以是别的
        mv.addObject("name","model and view");
//        设置需要返回的页面名称
        mv.setViewName("resp4");
        return mv;//返回的是一个对象
    }
}
