import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class test {
    public static void main(String[] args) {
//       float a = 19.3333333333333f;
//        System.out.println(a*3);
//        Student222 s = new xiaoming();
//        s.doSome();
//        String a = "\u4f18\u79c0";
//        System.out.println(a);
        try {
            byte[] b = new byte[32];
            FileInputStream fis = new FileInputStream("C:\\Users\\10593\\Desktop\\test.data");
            int count = 0;
            count = fis.read(b);
            while(count !=-1) {

                System.out.println(new String(b, 0, count));
                count = fis.read(b);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}