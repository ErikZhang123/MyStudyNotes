package interceptor08.interceptor08.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping("/user/account")
    @ResponseBody
    public String userAcc(){
        return "accoung 正在运行";
    }

    @RequestMapping("/user/login")
    @ResponseBody
    public String userLogin(){
        return "login正在运行 ";
    }

}
