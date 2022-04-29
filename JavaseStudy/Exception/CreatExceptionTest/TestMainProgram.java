package Exception.CreatExceptionTest;

public class TestMainProgram {
    public static void main(String[] args) {
        Stacktest s = new Stacktest();
        try {
            for(int i=0;i<10;i++)
            s.push(new Object());//在这个位置会报错，而在使用的时候需要catch掉这个异常
            s.push(new Object());
        } catch (PushIndexException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            for(int i=0;i<10;i++)
            s.pop();
            s.pop();
        } catch (PopIndexException e) {
            System.out.println(e.getMessage());
        }

    }
}
