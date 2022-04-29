package ormmysql11.ormmysql11.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ormmysql11.ormmysql11.vo.Student;

/**SpringBoot中需要使用Mapper注解来表示这个接口是dao接口，要创建这个接口的代理对象*
 * @Mapper 的缺点在于 ， 如果有很多接口，那么每个接口都需要加这个注解，比较麻烦
 * 可以使用 @MapperScan，放在启动类之上
 * */
//注意：配置文件的名字要和接口的名字一致

//@Mapper
public interface studentInfo {
    Student selectById(@Param("stuId")Integer id);
}
