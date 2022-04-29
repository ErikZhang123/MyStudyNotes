package CollectionAndGeneric.Set.TreeSet;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetdemo2 {
    public static void main(String[] args) {
        Set<Student> s = new TreeSet<>();
        s.add(new Student("zhangsan",18));
        s.add(new Student("lisi", 20));
        s.add(new Student("wangwu",20));
        s.add(new Student("zhaoliu",21));
        s.add(new Student("zhangsan",18));//只输出一个
        s.add(new Student("lisi",20));//只输出一个
        s.add(new Student("曹尼玛",22));
        s.add(new Student("王大炮",21));
        s.add(new Student("狗gb",18));
        Iterator it = s.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
        System.out.println(s.size());
    }
    static class Student implements Comparable<Student>
    {
       String name;
       int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public int compareTo(Student student) {
            //当涉及到字符串的比较时，需要使用String的compareTo方法使其返回ASCII码的差值
            //在自建类重写compareTo的时候需要特别注意自建类是以什么作为比较的，这直接影响TreeSet对于重复性的判断。
            if(this.name.equals(student.name))
            return this.age-student.age;
            else {
                return this.name.compareTo(student.name);
            }

        }
    }
}
