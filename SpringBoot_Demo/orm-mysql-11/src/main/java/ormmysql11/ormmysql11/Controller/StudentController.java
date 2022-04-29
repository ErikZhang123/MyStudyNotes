package ormmysql11.ormmysql11.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ormmysql11.ormmysql11.service.StudentService;
import ormmysql11.ormmysql11.vo.Student;

import javax.annotation.Resource;

@Controller
public class StudentController {

    @Resource
    private StudentService service ;

    @RequestMapping("/student/query")
    @ResponseBody
    public String queryStudent(Integer id ){
        Student s = service.queryStudent(id);
        return "Hello! "+s.toString();
    }
}
