package com.Project1.Controllers;

import com.Project1.Domain.Student;
import com.Project1.Services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping(value="/student")
public class StudentController {


    @Resource
    private StudentService studentService;
    //注册
    @RequestMapping("/add.do")
    public ModelAndView addStudent(Student student){
        ModelAndView mv = new ModelAndView();
        //调用service处理student
        int num = studentService.addStudent(student);

        if(num>0)
            mv.addObject("register_result","注册成功");
        else{
            mv.addObject("register_result","注册失败");
        }
        mv.setViewName("add_result");
        return mv;
    }
    //测试时可以直接访问这个"接口" 来测试是否成功
    @RequestMapping("/select.do")
    @ResponseBody
    public List<Student> selectStudent(){
        //参数检查等数据处理
        List<Student> list = studentService.selectStudent();
        return list; // 返回jason数组
    }

}
