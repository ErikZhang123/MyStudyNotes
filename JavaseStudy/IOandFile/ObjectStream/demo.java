package IOandFile.ObjectStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

/*
���л���Serialize����Ὣjava����洢���ļ��У��ǽ�java�����������Ϣ��Ϊ�������֣�Ȼ�󱣴�����
�����л���Deserialize������Ӳ���ϵ��������»ָ����ڴ��У��ָ���java����

�������л��汾�ţ�
File��Setting��Editor,Inspections----->serialization----->��serialable class without 'serialVersionUID'�ϴ�
------>apply-----OK---> ��������ʹ��ALT + ENTER ��������ȫ��Ψһ��ŵ�UID
* */
public class demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s = new Student(18,"����");
        Collection<Student> c  = new ArrayList();
        c.add(new Student(19,"����"));
        c.add(new Student(25,"����"));
        c.add(new Student(32,"����"));
        c.add(new Student(45,"�ϰ�"));
//        ���л���������
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("STUDENTS"));
//        ���л��������ʱʹ�ü��ϵ���ʽ
        ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("ListSerialization"));
        oos2.writeObject(c);
        oos.writeObject(s);

        oos2.flush();
        oos2.close();

        oos.flush();
        oos.close();
//      �����л���������
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("STUDENTS"));
        Object ds = ois.readObject();
        System.out.println(ds);
        ois.close();
//      �����л�������󣬼������л�һ�����϶���
        ObjectInputStream ois2 = new ObjectInputStream( new FileInputStream("ListSerialization"));
        Collection<Student> c2 = (Collection<Student>) ois2.readObject();
        for (Student student:c2
             ) {
            System.out.println(student);
        }
    }
}
class Student implements Serializable {
//    JVM����֪��Serializable�ӿڵ�ʱ�������һ����Ӧ�����л��汾�ţ��ð汾�ű����뷴���л�ʱ�İ汾��һ�£�����ᱨ��
//    InvalidClassException
//    �������ʹ���Զ����ɴ��룬��ôÿ���޸Ĵ����Ժ󶼻������µ����а汾��s
//    Ϊ�˱�֤�����޸Ĵ��룬���л��汾��һ�����ֶ���д
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
