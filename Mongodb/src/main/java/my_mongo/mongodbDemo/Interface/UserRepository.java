package my_mongo.mongodbDemo.Interface;


import my_mongo.mongodbDemo.entity.MyUser;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
public interface UserRepository extends MongoRepository<MyUser,String> {

}
