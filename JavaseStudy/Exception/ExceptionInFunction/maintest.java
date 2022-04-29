package Exception.ExceptionInFunction;

public class maintest {
    public static void main(String[] args) {
        testfunction t = new testfunction();
        try {
            t.fun();
        } catch (TestException e) {
            System.out.println(e.getMessage());
        }


    }
}
