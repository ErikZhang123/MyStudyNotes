package com.Annotation.ba01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

//@Component    不对value属性进行赋值，会以类名的首字母小写形式来指定bean的id
//@Component (value = "student001")
@Component ("student001")//只有一个值时value可以被省略，bean的id默认就是student001
public class Student {
    private String name;
    // 对简单类型进行赋值用@Value,由于源码中value的类型为String，所以不论是什么简单类型，value都必须用""修饰。
    //@Value可以直接用在变量声明的上方，此时不使用set方法。也可以用在变量的set()方法声明的上方，即使用set方法赋值。
    @Value(value = "20")
    private int age;
    //对引用类型赋值，需要首先创建出引用类型的bean。spring在使用组件扫描器读取的过程中，会先创建出所有类的对象，然后再拿所需要用到对象进行赋值。

    @Autowired(required = false)//默认使用byType注入，也可以通过@Qualifier（"对象id"）进byName赋值
    //required 的值决定了在赋值失败的时候是否报错，false则不报错，仅不进行赋值操作；true则报错并终止程序
    @Qualifier("myschool")//结果为id=myschool的对象
    private Building school;
//    @Resource(name = "USYDschool")//默认使用byName，会匹配id与变量名一致的bean，如果赋值失败，再使用byType。
//    如果有多个同源类对象则会报错。
//    如果对name属性进行赋值，则会只使用byName规则注入。
    @Resource
    private Eat dinnerHouse;

    public Eat getDinnerHouse() {
        return dinnerHouse;
    }

    public void setDinnerHouse(Eat dinnerHouse) {
        this.dinnerHouse = dinnerHouse;
    }

    public Building getSchool() {
        return school;
    }

    public void setSchool(Building school) {
        this.school = school;
    }



    public Student() {
    }

    public Student(String name, int age, School school) {
        this.name = name;
        this.age = age;
        this.school=school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName被调用");

        this.name = name;
    }
//本类中并不存在Email属性
    public void setEmail(String name) {
        System.out.println("setEmail被调用");
    }

    public int getAge() {
        return age;
    }

    @Value(value= "30")
    public void setAge(int age) {
        System.out.println("setAge被调用");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                ", dinnerHouse=" + dinnerHouse +
                '}';
    }
}
