package CollectionAndGeneric.Collectionfuntions;

import java.util.ArrayList;
import java.util.Collection;

public class functionsTest {
    public static void main(String[] args) {
        Collection c = new ArrayList();

        Student s1 = new Student("john");
        Student s2 = new Student("john");//List集合还是可以重复的
        c.add(s1);
        c.add(s2);
        Student s3 = new Student("john");
        System.out.println(c.contains(s3));//false,因为自建类在没有重写equals方法之前比较的是栈内存中的地址值。
//        重写equals方法后contains结果为true
//        c.remove(s3);//在Student中没有重写equals方法之前，remove只会删除对应地址的元素
        c.remove(s3);//但是注意！remove方法一次只能删除一个元素，要删除多个相同元素需要循环
        c.remove(s3);
        c.remove(s3);
        System.out.println(c.size());
    }
}


