package IOandFile.ObjectStream;

import java.io.*;

/*
* transient����ؼ���
*  ���ùؼ������ε����Բ���������л�
* */
public class TransientDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        newStudent ns = new newStudent(18,"����","��");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("NEWSTUDENT"));
        oos.writeObject(ns);
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("NEWSTUDENT"));
        System.out.println(ois.readObject());
//      ���ʱ�ᷢ��sex����Ϊnull��˵�������л���ʱ��û�н�sex���л����������ݷ����л�Ϊnull
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
