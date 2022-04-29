package filters10.filters10.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class myController {

    @RequestMapping("/user/account")
    @ResponseBody
    public String useracc(){
        return "userrrrrrrrrrrr";
    }

    @RequestMapping("/query")
    @ResponseBody
    public String userquery(){
        return "userrrrrrrrrrrr";
    }
}
