package my_mongo.demo;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import my_mongo.mongodbDemo.DemoApplication;
import my_mongo.mongodbDemo.entity.MyUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Pattern;

@SpringBootTest(classes = DemoApplication.class)
class MongoTemplateDemoTest {

    @Autowired
    MongoTemplate mongoTemplate;
    @Test
    void demo1() {
        MyUser user = new MyUser();
        user.setName("test");
        user.setAge(18);
        System.out.println(mongoTemplate.getDb().getName());
        List<MyUser> list= mongoTemplate.findAll(MyUser.class);
        mongoTemplate.insert(user);
//        for(MyUser u:list){
//            System.out.println(u.getName());
//        }
        System.out.println("添加成功");
    }
    @Test
    void fetchById(){
        MyUser user  = mongoTemplate.findById("625f63b7d19cbd55b1b08cfe",MyUser.class);
        assert user != null;
        System.out.println(user.getName());
    }


//    按条件查询
    @Test
    void fetchByCondition(){
        Query query = new Query(Criteria.where("name").is("zhangsan")
                                    .and("age").is(18));
        List<MyUser> users = mongoTemplate.find(query,MyUser.class);
        for(MyUser u : users){
            System.out.println(u.getName()+u.getId()+u.getAge());
        }
    }

//    模糊查询
    @Test
    void fetchLikList(){
        String name = "est";
        String regex = String.format("%s%s%s","^.*",name,".*$");
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        //使用正则来查找
        Query query = new Query(Criteria.where("name").regex(pattern));
        List<MyUser> list = mongoTemplate.find(query,MyUser.class);
        for(MyUser i : list){
            System.out.println(i.getId()+","+i.getName());
        }
    }
//    分页查询
    @Test
    void fetchLimit(){
        Integer pageNo = 1;
        Integer pageSize = 3;
        //构建查询条件
        String name = "est";
        String regex = String.format("%s%s%s","^.*",name,".*$");
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Query query = new Query(Criteria.where("name").regex(pattern));
        long count = mongoTemplate.count(query,MyUser.class);
        List<MyUser> list = mongoTemplate.find(query.skip( (pageNo - 1) *pageSize ).limit(pageSize),MyUser.class);
        System.out.println(list); // 只返回3个
        System.out.println(count); // 总共有8个
    }

//    修改
    @Test
    void modify(){
        //根据id查询
        MyUser user = mongoTemplate.findById("625f63b7d19cbd55b1b08cfe",MyUser.class);
        assert user != null;
        user.setName("I am free!!!!!");
        user.setAge(200);
        Query query = new Query(Criteria.where("_id").is(user.getId()));
        Update update = new Update();
        update.set("name",user.getName());
        update.set("age",user.getAge());
        UpdateResult result = mongoTemplate.upsert(query,update,MyUser.class);
        long modified_num = result.getMatchedCount();
        assert(modified_num>=1);
    }
//    删除
@Test
    void delete(){
    //根据id查询
    String id = "625f63b7d19cbd55b1b08cfe";
    MyUser user = mongoTemplate.findById(id,MyUser.class);
    assert(user != null);
    Query query = new Query(Criteria.where("_id").is(user.getId()));
    DeleteResult result = mongoTemplate.remove(query,MyUser.class);
    long delete_num = result.getDeletedCount();
    assert(delete_num>=1);
}
}
