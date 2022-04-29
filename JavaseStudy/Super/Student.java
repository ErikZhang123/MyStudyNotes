package Super;

public class Student extends Person{
    String StudentNumber;

    public Student(String name, int age, String sex) {
        super(name, age, sex);
    }

    public Student(String name) {
        super(name);
    }

    public Student(int age, String sex) {
        super(age, sex);
    }
    public void doSome()
    {
        System.out.println(super.name);//在子类中调用父类对象
    }
}
