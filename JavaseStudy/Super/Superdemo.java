package Super;
/*
* super只能出现在实例方法和构造方法中，不能出现在静态方法中
* 语法：super 或 super()
* 大多时候super可以省略，但是在子类中访问父类同名对象的时候super不能省略
* 例如super.name；
* super()只能出现在构造方法的第一行，通过当前构造方法调用父类中的其他构造方法。
* 其目的是在创建子类对象的时候先创建父类
* */
public class Superdemo {
    public static void main(String[] args) {
        Person p = new Student("张三",18,"男");
        Student s = (Student)p;

    }
}
