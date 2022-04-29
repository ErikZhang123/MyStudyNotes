package springbootapplicationcontext07.demo.service;


import org.springframework.stereotype.Service;

@Service("userService")
public class myservice implements UserService{

    public String hello(String name){
        System.out.println(name+"欢迎回来");
        return " hello "+ name;
    }

}
