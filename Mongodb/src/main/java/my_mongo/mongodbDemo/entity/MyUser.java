package my_mongo.mongodbDemo.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
// 这个是数据库中表的名字，需要保证大小写一致，可以通过 show dbs -> use db -> show table 来查看具体使用哪个表
@Document("User")
public class MyUser {
    @Id
    private String id;
    private Integer age;
    private String name;

}
