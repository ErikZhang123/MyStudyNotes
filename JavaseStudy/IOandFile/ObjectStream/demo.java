package IOandFile.ObjectStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

/*
序列化（Serialize）后会将java对象存储到文件中，是将java对象的数据信息分为几个部分，然后保存下来
反序列化（Deserialize）即将硬盘上的数据重新恢复到内存中，恢复成java对象

生成序列化版本号：
File，Setting，Editor,Inspections----->serialization----->在serialable class without 'serialVersionUID'上打钩
------>apply-----OK---> 在类名上使用ALT + ENTER 可以生成全球唯一编号的UID
* */
public class demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s = new Student(18,"张三");
        Collection<Student> c  = new ArrayList();
        c.add(new Student(19,"李四"));
        c.add(new Student(25,"王五"));
        c.add(new Student(32,"赵六"));
        c.add(new Student(45,"老八"));
//        序列化单个对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("STUDENTS"));
//        序列化多个对象时使用集合的形式
        ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("ListSerialization"));
        oos2.writeObject(c);
        oos.writeObject(s);

        oos2.flush();
        oos2.close();

        oos.flush();
        oos.close();
//      反序列化单个对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("STUDENTS"));
        Object ds = ois.readObject();
        System.out.println(ds);
        ois.close();
//      反序列化多个对象，即反序列化一个集合对象
        ObjectInputStream ois2 = new ObjectInputStream( new FileInputStream("ListSerialization"));
        Collection<Student> c2 = (Collection<Student>) ois2.readObject();
        for (Student student:c2
             ) {
            System.out.println(student);
        }
    }
}
class Student implements Serializable {
//    JVM在认知到Serializable接口的时候会生成一个相应的序列化版本号，该版本号必须与反序列化时的版本号一致，否则会报错
//    InvalidClassException
//    但是如果使用自动生成代码，那么每次修改代码以后都会生成新的序列版本号s
//    为了保证可以修改代码，序列化版本号一般由手动书写
    private static final long serialVersionUID = 000000001L;

    int age ;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
