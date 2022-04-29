package IOandFile.ObjectStream;

import java.io.*;

/*
* transient游离关键字
*  被该关键字修饰的属性不会参与序列化
* */
public class TransientDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        newStudent ns = new newStudent(18,"张三","男");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("NEWSTUDENT"));
        oos.writeObject(ns);
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NEWSTUDENT"));
        System.out.println(ois.readObject());
//      输出时会发现sex这里为null，说明在序列化的时候并没有将sex序列化，导致数据反序列化为null
    }
}
class newStudent implements Serializable
{
    private static final long serialVersionUID = 1493983816068477978L;
    int age;
    String name;
    transient String sex;

    public newStudent(int age, String name, String sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "newStudent{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
