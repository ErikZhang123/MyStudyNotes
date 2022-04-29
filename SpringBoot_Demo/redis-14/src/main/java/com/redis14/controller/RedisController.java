package com.redis14.controller;
import com.redis14.vo.Student;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class RedisController {
//    RedisTemplate是一个泛型，其中只能写<String,String> , <Object,Objecet> 或者不写
    //注意，其名称就叫做redisTemplate，因为框架创建的对象就叫这个名字使用Resource进行赋值
    @Resource
    private RedisTemplate redisTemplate;
//      使用StringRedisTemplate 可以避免在插入时，key部分前半部分会产生的一些符号问题
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @PostMapping("/redis/insert/{k}/{v}")
    public String query( @PathVariable String k ,@PathVariable String v){
        //他有很多操作类，来操作不同的数据类型
        // 获取所需要的操作类型，比如操作String类型的数据
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set(k,v);
        return "使用了stringStringValueOperations对象";
    }
//    向Redis中添加数据
    @PostMapping("/redis/add")
    public String add(String name , String value){
        //他有很多操作类，来操作不同的数据类型
        // 获取所需要的操作类型，比如操作String类型的数据
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("myname","caonimaaaaa");
        return "向Redis添加String数据成功";
    }
//  获取数据
    @PostMapping("/redis/query")
    public String query( String k ){
        //他有很多操作类，来操作不同的数据类型
        // 获取所需要的操作类型，比如操作String类型的数据
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object v = valueOperations.get(k);
        return "key = "+k +", 值是： "+v;
    }
    /***/
    @PostMapping("/redis/serialize")
    public String Serialize(){
        //设置key使用String序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置value
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.opsForValue().set("张三","Value");
        return "定义key和value的序列化操作";
    }

    /**用json序列化，将java对象转为json存储*/
    @PostMapping("/redis/json")
    public String addJson(){
        Student s = new Student();
        s.setAge(18);
        s.setName("zhangsan");
        s.setSid(1002);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 将数据进行json序列化
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Student>(Student.class));
        redisTemplate.opsForValue().set("mystudent",s);
        //获取的时候，也会将获得的json自动反序列化为对象
        return "Student 转化为Json格式传输";
    }
//      获取对象
    @PostMapping("/redis/getjson")
    public String getJson(){

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // 将数据进行json序列化
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Student>(Student.class));
        Student s = (Student) redisTemplate.opsForValue().get("mystudent");
        //获取的时候，也会将获得的json自动反序列化为对象
        return "获得的Student是： "+s;
    }
}
