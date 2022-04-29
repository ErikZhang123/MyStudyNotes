package ormmysql11.ormmysql11.service;

import ormmysql11.ormmysql11.vo.Student;

public interface StudentService {
    Student queryStudent(Integer stuId);
}
