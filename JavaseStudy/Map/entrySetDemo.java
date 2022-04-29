package Map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class entrySetDemo {
    /*
     * Set<JavaseStudy.Map.Entry<K,V>> entrySet();将Map集合转换成Set集合
     * JavaseStudy.Map.Entry<K,V>是Map的静态内部类
     * */
        public static void main(String[] args) {
            Map<Integer, String> map = new TreeMap<>();
            map.put(1, "张三");//键值对
            map.put(2, "b");
            Set<Map.Entry<Integer, String>> s = map.entrySet();

            Iterator<Map.Entry<Integer, String>> it = s.iterator();

            while (it.hasNext()) {
                Map.Entry<Integer, String> node = it.next();
                Integer key = node.getKey();
                String value = node.getValue();
                System.out.println(key + "=" + value);
            }
//        for (JavaseStudy.Map.Entry<Integer,String> m:s  // 数据量较大时采用此方式，其效率较高
//             ) {
//            System.out.println(m.getKey()+"------>"+m.getValue());
//        }
        }
}
