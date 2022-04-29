package com.thymeleaf20.controller;

import com.thymeleaf20.vo.MyUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tpl")
public class ThymeleafController {

    @RequestMapping("/expression1")
    public String expression1(Model model){
        model.addAttribute("site","baidu.com");
        model.addAttribute("user1",new MyUser("张三",18,1001));
        return "expression1";
    }
//星号变量表达式测试
    @RequestMapping("/expression2")
    public String expression2(Model model){
        model.addAttribute("site2","google.com");
        model.addAttribute("user2",new MyUser("李四",23,1002));
        return "expression2";
    }

    @GetMapping("/link")
    public String expression3(Model model){
        model.addAttribute("userid",1003);
        return "link";
    }
//    测试链接表达式的地址
    @GetMapping("/queryAccount")
    @ResponseBody
    public String queryAccount(Integer id){
        return "queryAccount, 参数 id="+id;
    }

    @GetMapping("/queryUser")
    @ResponseBody
    public String queryUser(String name,Integer age){
        return "queryUser, 参数 name="+name + "， age = "+age;
    }
//模版属性
    @GetMapping("/useProperty")
    public String useProperty(Model model){
        model.addAttribute("method","post");
        model.addAttribute("userid","1234");
        return "html-property";
    }

    @GetMapping("/loginServlet")
    @ResponseBody
    public String loginServlet(Model model){
        return "loginServlet";
    }

    @GetMapping("/eachList")
    public String eachList(Model model){
        List<MyUser> list = new ArrayList<>();
        list.add(new MyUser("张三",18,1001));
        list.add(new MyUser("张4",19,1002));
        list.add(new MyUser("张5",20,1003));
        list.add(new MyUser("张6",21,1004));
        model.addAttribute("myusers",list);
        return "eachList";
    }

    @GetMapping("/getMap")
    public String geMap(Model model){
        Map<Integer,MyUser> map = new HashMap<>();
        map.put(1,new MyUser("李四",18,1001));
        map.put(2,new MyUser("李5",28,1002));
        map.put(3,new MyUser("李6",38,1003));
        map.put(4,new MyUser("李7",48,1004));
        map.put(5,new MyUser("李8",58,1005));
        model.addAttribute("mymap",map);
        return "getmap";
    }

    @GetMapping("/inline")
    public String inline(Model model){
        model.addAttribute("data","male");
        return "inline";
    }

//    模版内置对象
    @GetMapping("/baseObject")
    public String baseObject(Model model, HttpServletRequest request , HttpSession session) {
        model.addAttribute("name","获取到Controller中通过model对象添加");
        request.setAttribute("requestData","获取到Controller中通过request对象添加");
        session.setAttribute("SessionData","获取到Controller中通过session对象添加");

        return "baseObject";
    }
}
