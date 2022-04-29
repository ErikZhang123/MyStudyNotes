package com.restful13.controller;

import org.springframework.web.bind.annotation.*;

//复合注解
@RestController
public class myRestController {

/**    @PathVariable()获取url中的数据， 该注解放在方法的形参之前
        属性：  value: 路径变量名.  当路径变量名称和形参名一样的时候，value可以省略。
        比如：http://localhost:9002/myboot/Student/1001
        但是由于url也只能传简单类型的变量，所以不能传对象

 问题：  当url中的变量数据，并没有和指定参数相对应，会产生歧义
        比如：http://localhost:9002/myboot/Student/20 ， 这里20想表示的是年龄，
 因此，要保证在设计的时候 "url+ 请求方式" 必须唯一
如果都是get方式
/student/{stuid}
/student/{age}
  这样就不行
 但是如果一个是get，一个是put，就是可以的
*/
    @GetMapping("/student/{stuid}/{age}") // 在此处表明第几个位置的参数对应的变量
    //value的值就是url中对应位置的值
    public String selectStudent( @PathVariable(value="stuid") Integer studentId,
                                 @PathVariable(value="age") Integer age){
            return "查询学生 id: "+studentId+"; 年龄： "+age;
    }

    @PutMapping("/student/{stuid}/{age}")
    public String modifyStudent(@PathVariable String stuid , @PathVariable Integer age){
        return "学生id："+stuid+" 年龄："+age+"已被修改";
    }

    @PutMapping("/student/test")
    public String test(){
        return "使用页面发送的put类型请求的测试成功";
    }

    @DeleteMapping("/student/testDelete")
    public String testdelete(){
        return "使用页面发送的Delete类型请求的测试成功";
    }

}
