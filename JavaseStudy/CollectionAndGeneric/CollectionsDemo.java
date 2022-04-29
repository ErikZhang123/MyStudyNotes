package CollectionAndGeneric;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/*
*
* Collecitons是一个工具类
* 注意Collection和Collections的拼写不同
* 主要掌握两个方法：
* collections. sorted()
* 对list中的元素进行排序，在此之前必须保证list中的元素实现了Comparable接口
* 对于Set进行排序时，要将其转换为List
*
* collecitons.synchronizedList(list)
* 将非线程安全的list集合转为线程安全的
* */
public class CollectionsDemo {
    public static void main(String[] args) {
        List<Student> mylist = new ArrayList<>();

        mylist.add(new Student(18,"张三"));
        mylist.add(new Student(20,"李四"));
        mylist.add(new Student(22,"赵六"));
        mylist.add(new Student(18,"王五"));
        Iterator it = mylist.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
        System.out.println("______________________________________");

        Collections.synchronizedList(mylist);
        Collections.sort(mylist);

        Iterator<Student> it2 = mylist.iterator();
        while(it2.hasNext())
        {
            System.out.println(it2.next());
        }


    }
    static class Student implements  Comparable<Student> {
        int age;
        String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int compareTo(Student student) {
            if (!this.name.equals(student.name))
                return this.age - student.age;
            else
                return this.name.compareTo(student.name);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
