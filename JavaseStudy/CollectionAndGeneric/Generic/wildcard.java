package CollectionAndGeneric.Generic;

import java.util.ArrayList;
import java.util.List;

//wildcard
//格式：
// List<? extends 父类> 表示，<任何继承指定父类的类>== a list of <what extends parent class >
// List<? super 子类>表示，<指定子类的父类>== a list of <what is the parent class of child class>
public class wildcard {
//    List<Object> l = new ArrayList<String>();
//    以上这种形式是不允许的，左边和右边<>中的类型必须一致
//    但是，通过wildcard可以解决这个问题
public static void main(String[] args) {
    List<? extends Object> l = new ArrayList<String>();
//    像以上这种形式，左边就是wildcard，则编译允许
//    List<person> p = new ArrayList<employee>();不允许
    List<? extends person> p = new ArrayList<employee>();
    List<? super employee> p2 = new ArrayList<person>();

    List<employee> p3 = new ArrayList<employee>();
    List<customer> p4= new ArrayList<customer>();
//  可以使用wildcard 用于接收读取相同父类/子类的Collection
    test01(p);
    test01(p4);
}

    public static void test01(List<? extends person> list/*,person p1*/){
        for (person p :list) {
            System.out.println(p.name);
        }
    //    list.add(p1);编译错误，extends 只能用于读操作
    }

    public static void test02(List<? super employee> list,employee e){
        list.add(e);
    }
}
class person{
    String name;
}
class employee extends person{

}
class customer extends person{

}

