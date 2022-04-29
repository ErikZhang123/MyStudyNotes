package ormmysql11.ormmysql11.service;


import org.springframework.stereotype.Service;
import ormmysql11.ormmysql11.dao.studentInfo;
import ormmysql11.ormmysql11.vo.Student;

import javax.annotation.Resource;


@Service
public class StudentServiceImp implements StudentService {

    @Resource
    studentInfo studentInfo;

    @Override
    public Student queryStudent(Integer stuId) {
        Student s = studentInfo.selectById(stuId);
        return s;
    }
}
