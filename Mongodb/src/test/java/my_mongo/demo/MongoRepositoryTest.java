package my_mongo.demo;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import my_mongo.mongodbDemo.DemoApplication;
import my_mongo.mongodbDemo.Interface.UserRepository;
import my_mongo.mongodbDemo.entity.MyUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.regex.Pattern;

@SpringBootTest(classes = DemoApplication.class)
public class MongoRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void save(){
        MyUser user = new MyUser();
        user.setName("Erik");
        user.setAge(18);
        userRepository.save(user);
    }
    @Test
    void findAll(){

        List<MyUser> user = userRepository.findAll();
        System.out.println(user);
    }

    @Test
    void findbyId(){
        String id = "625fd44d1117765ccf8cd602";
        MyUser user = userRepository.findById(id).get();
        System.out.println(user);
    }

    @Test
    void findByCondition(){
        MyUser user = new MyUser();
        user.setName("Erik");
        user.setAge(18);
        Example<MyUser> userExample = Example.of(user);
        List<MyUser> list = userRepository.findAll(userExample);
        System.out.println(list);
    }

//    模糊查询
@Test
void fetchLike(){
//        设置模糊查询匹配规则
    ExampleMatcher matcher = ExampleMatcher.matching().
            withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).
            withIgnoreCase();

    MyUser user = new MyUser();
    user.setName("E");
    user.setAge(18);
    Example<MyUser> userExample = Example.of(user,matcher);
    List<MyUser> list = userRepository.findAll(userExample);
    System.out.println(list);
}
    //    分页查询
    @Test
    void fetchLimit(){
//         这里的0代表第一页
        Pageable pageable = PageRequest.of(0,3);
        //构建查询
        MyUser user = new MyUser();
        user.setName("Erik");
        user.setAge(18);
        Example<MyUser> userExample = Example.of(user);
        Page<MyUser> page = userRepository.findAll(userExample,pageable);
        int count = page.getTotalPages(); //可以用他的方法获取返回参数
        System.out.println(page); // 只返回3个
    }

    //    修改
    @Test
    void modify(){
        //根据id查询
        MyUser user = userRepository.findById("625fd44d1117765ccf8cd602").get();
        user.setName("aaaaaaaaaaaa");
        user.setAge(100);
//       save方法会根据是否有id值来判断是修改还是添加
        MyUser save = userRepository.save(user);
        System.out.println(save);
    }
    //    删除
    @Test
    void delete(){
        userRepository.deleteById("625fd44d1117765ccf8cd602");
    }
}
