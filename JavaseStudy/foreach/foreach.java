package foreach;

import java.util.ArrayList;
import java.util.Collection;

public class foreach {
    public static void main(String[] args) {
        Collection<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");
        a.add("e");
        a.add("f");
        for (String s:a) {//注意泛型
            System.out.println(s);
        }
    }
}
