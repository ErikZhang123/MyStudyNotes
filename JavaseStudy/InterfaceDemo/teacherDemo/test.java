package InterfaceDemo.teacherDemo;

public class test {
    public static void main(String[] args) {
        Teacher t1 = new EnglishTeacher();
        Teacher t2 = new MathTeacher();
        try {
            t1.study();
        } catch (StopTeachingException e) {
            e.printStackTrace();
            System.out.println("��������");
        }
        t2.flag = true;
        try {
            t2.study();
        } catch (StopTeachingException e) {
            System.out.println("��������");
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();

            }

        }
    }
}
