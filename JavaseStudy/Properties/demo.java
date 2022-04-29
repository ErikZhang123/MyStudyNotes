package Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
/*
*
* */
public class demo {
    public static void main(String[] args) throws IOException {
        Properties p = new Properties();
        p.load(new FileInputStream("D:\\IDEA\\src\\JavaseStudy\\Properties\\userinfo.properties"));
        Map<String,String> m = new HashMap<>();

        System.out.println(p.getProperty("zhangsan"));

    }
}
