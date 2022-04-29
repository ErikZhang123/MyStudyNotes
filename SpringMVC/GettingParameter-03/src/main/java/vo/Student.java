package vo;
//仅用于保存请求参数值
public class Student {
    String name;
    int age;

    public Student(){
        System.out.println("无can构造使用");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("使用了setName方法");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
