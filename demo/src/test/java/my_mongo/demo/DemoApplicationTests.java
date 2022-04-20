package my_mongo.demo;

import my_mongo.demo.entity.MyUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

//
    @Autowired
    MongoTemplate mongoTemplate;
    @Test
    void demo1() {
        MyUser user = new MyUser();
        user.setName("zhaoliu");
        System.out.println(mongoTemplate.getDb().getName());
        List<MyUser> list= mongoTemplate.findAll(MyUser.class);
//        mongoTemplate.insert(user);
        for(MyUser u:list){
            System.out.println(u.getName());
        }
        System.out.println("添加成功");
    }

}
