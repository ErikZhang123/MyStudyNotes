package mybatisDemo.DAO;



import mybatisDemo.Domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDAO {
    //Mybatis在使用动态代理的时候会根据给出的接口自动创建一个实现类
    public abstract List<Student> selectAll();
    public abstract int insertStudent(Student student);
}
