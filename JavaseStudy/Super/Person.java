package Super;

public class Person {
    String name;
    int age;
    String sex;

    public Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int age, String sex) {
        this.age = age;
        this.sex = sex;
    }
}
