package mybatisDemo.DAO;



import mybatisDemo.Domain.Student;
import mybatisDemo.Domain.Student2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDAO {
    //Mybatis在使用动态代理的时候会根据给出的接口自动创建一个实现类，
    public abstract List<Student> selectAll();
//    当传入多个参数的时候使用 @Param（"参数名"） 所传入的参数类型 名称
    public abstract List<Student> selectByIdAndName(@Param("id") Integer id
                                                    ,@Param("name") String name);
    public abstract int insertStudent(Student student);
    public abstract List<Student> selectTwo(Student student);
    public abstract List<Student> selectbyOtherName(Student student);
    public abstract List<Student2> resultMapTest();
    public abstract List<Student> blurSelect(String name);
    public abstract int selectStudentByAge(List<Student> students);
}
