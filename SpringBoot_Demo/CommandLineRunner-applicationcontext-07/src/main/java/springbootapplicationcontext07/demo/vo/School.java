package springbootapplicationcontext07.demo.vo;

public class School {

    String name;
    int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
