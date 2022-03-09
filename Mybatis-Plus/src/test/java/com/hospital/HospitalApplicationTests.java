package com.hospital;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hospital.dao.UserMapper;
import com.hospital.entity.hospital_user;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.jsf.el.WebApplicationContextFacesELResolver;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class HospitalApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void findAll() {
        //注意，在使用时实体类的名字就被作为表的名字去数据库中进行查找。
        //查找时的字段名会通过属性名大写字母前加_ 来表示
        //比如在实体类中是userAge , 查找的时候就是 user_Age
        List<hospital_user> users =  userMapper.selectList(null);
        System.out.println("User1 : " + users);
        //多个id批量查询，参数是一个Collection类型
        List<Long> ids = new ArrayList<>();
        ids.add(1500408011659165698L);
        ids.add(1500408118815236098L);
        ids.add(1500408286717472769L); // 条件是 where id in （1，2，3）
        List<hospital_user> users2 =  userMapper.selectBatchIds(ids);
        System.out.println("User2 : " + users2);

        // MAP 构建条件查询 , 一般不太用，一般使用条件构造器
        Map<String,Object> colmnMap = new HashMap<>();
        colmnMap.put("user_Name","qiqi");
        colmnMap.put("user_Age","7");
        List<hospital_user> users3  = userMapper.selectByMap(colmnMap);
        System.out.println("User3 : " + users3);
    }
    //分页查询 , 要在自己的配置类中引入插件， 比较常用
    //本质还是使用limit 和 count 来实现
    @Test
    public void pageSelect() {

        // 构造方法中有两个参数，第一个参数表示当前页，第二个表示当前页面显示的记录数量
        Page<hospital_user> page = new Page<>(1,3);
        // 分页的所有数据都封装在userspage这个对象中
        Page<hospital_user> userspage = userMapper.selectPage(page,null);
        long pages = userspage.getPages(); // 得到总页数
        long curr = userspage.getCurrent(); // 得到当前页
        List<hospital_user> list = userspage.getRecords(); //查询数据集合 ， 即当前页中的所有数据
        long records = userspage.getTotal(); // 表中一共有多少记录
        boolean b = userspage.hasNext(); // 是否有下一页
        boolean b1 = userspage.hasPrevious();// 是否有上一页
        System.out.println(pages);

    }
    @Test
    public void testAdd(){
        hospital_user user = new hospital_user();
        //如果没有设置主键，会调用主键策略，通过雪花算法
        user.setUserName("zhangsan");
        user.setUserAge(12);
        user.setUserEmail("111@qq.com");
        int result = userMapper.insert(user);
        System.out.println("成功添加了"+result+" 个用户");
    }

    @Test
    public void testModify(){
        hospital_user user = new hospital_user();
        user.setUserId(1500408118815236098L);
        user.setUserName("zhaoliu");
        user.setUserEmail("333@qq.com");
        // 根据主键id修改
        int result = userMapper.updateById(user);
        System.out.println("成功修改了"+result+" 个用户");
    }
//MP可以通过自动填充的方式来完成字段赋值工作（不用写创建对象时候的set方法）
    /**要在表中添加 create_time , update_time 字段，类型都是datatime
     *  实体类中也添加这两个属性，类型为Date
     *  在实体类的需要自动填充的属性上添加注解*/
    @Test
    public void testTian(){
        hospital_user user = new hospital_user();
        user.setUserName("baba");
        user.setUserAge(88);
        user.setUserEmail("88888@qq.com");
        // 自动填充创建时间，添加用户，注意是否create_Time字段被自动赋值了
        int result = userMapper.insert(user);
        System.out.println("成功添加了"+result+" 个用户");
    }
    @Test
    public void testTian2(){
        hospital_user user = new hospital_user();
        user.setUserId(1500415613628084226L);
        user.setUserAge(7);
        // 自动填充,注意是否update_Time字段被自动赋值了
        int result = userMapper.updateById(user);
        System.out.println("成功修改了"+result+" 个用户");
    }
    @Test
    public void testOptimize(){
        hospital_user user = userMapper.selectById(1500423230559698946L);
        user.setUserName("eight123");
        userMapper.updateById(user);
    }
//    删除，
    // 物理删除： 从表中真正抹去，无法恢复
    //逻辑删除： 在表中设置一个标志位，表中数据并没有真正删除，只是修改标志位。
    //逻辑删除可以防止误删，有恢复的可能，一般实际情况中就使用逻辑删除
    //需要在表中手动增加标志位字段，并在实体类中也增加响应的标志属性，使用@TableLogic注解
    // 类型是int类型， 但是如果表中的deleted 标志位是 null，则也会被视为删除
    @Test
    public void testDelete(){
       int result =  userMapper.deleteById(1500431381641592833L);
        System.out.println("删除了" + result + "个用户");
        List<hospital_user> users = userMapper.selectList(null);
        //可以看到虽然查询的时候查不到这个数据了，但是库中实际上还存在
        System.out.println("这是查询结果"+users);
    }
    /**条件查询构造器 Wrapper
     * 使用各种条件的符号来调用对应的方法，比如
     * ge，le ： 大于等于 ， 小于等于
     * gt , lt : 大于，小于
     * eq,ne: 等于，不等于
     * between , NotBetween: 有三个参数，第一个是字段名，第二第三个是范围的大小
     * like , notlike: 模糊查询, 两个参数， 第一个是字段名，第二个是模糊查询中需要查询的内容
     * like就是包含这个key的，notlike就是不包含，在java中的时候不要加%
     * likeLeft,LikeRight： left 和 right 决定了模糊查询的百分号的位置 比如：'%张'
     * orderBy， orderByDesc, orderByAsc,系列排序功能
     * */

    @Test
    public void testWrapper(){
        QueryWrapper<hospital_user> wrapper = new QueryWrapper<>();
        //第一个参数是字段名称，第二个是值
        wrapper.ge("user_Age", 21);
        //在 userMapper.selectList() 参数中传入wrapper
        List<hospital_user> list = userMapper.selectList(wrapper);
        System.out.println(list);

    }
}

