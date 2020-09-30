package com.haina.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestController {

    @RequestMapping("rest")
    public String rest(){
        return "rest";
    }

    //rest风格接口设计的要求
    //1. 不同的功能要使用与之对应的请求方法
    //2.参数传递要使用PathVariable

    @RequestMapping(value = "book/{id}",method = RequestMethod.GET)
    public String getBook(@PathVariable("id") int id){
        System.out.println(id);
        return "success";
    }

    @RequestMapping(value ="book/{id}",method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("id") int id){
        System.out.println(id);
        return "seccess";
    }

    @RequestMapping(value ="book/{id}",method = RequestMethod.PUT)
    public String putBook(@PathVariable("id") int id){
        System.out.println(id);
        return "u";
    }

    @RequestMapping(value ="book",method = RequestMethod.POST)
    public String addBook(Book book){
        System.out.println(book.getName());
        return "success";
    }

}
