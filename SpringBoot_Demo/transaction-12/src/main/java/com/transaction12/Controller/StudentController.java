package com.transaction12.Controller;

import com.transaction12.model.Student;
import com.transaction12.service.MyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class StudentController {

    @Resource
    MyService myServiceImp;
    @RequestMapping("/addStudent")
    @ResponseBody
    public String addStudent(String name , Integer age){
        Student s = new Student();
        s.setName(name);
        s.setAge(age);
        int num = myServiceImp.addStudent(s);
        return "添加了"+num+"个学生";
    }
}
