package Map;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class entrySetDemo {
    /*
     * Set<JavaseStudy.Map.Entry<K,V>> entrySet();��Map����ת����Set����
     * JavaseStudy.Map.Entry<K,V>��Map�ľ�̬�ڲ���
     * */
        public static void main(String[] args) {
            Map<Integer, String> map = new TreeMap<>();
            map.put(1, "����");//��ֵ��
            map.put(2, "b");
            Set<Map.Entry<Integer, String>> s = map.entrySet();

            Iterator<Map.Entry<Integer, String>> it = s.iterator();

            while (it.hasNext()) {
                Map.Entry<Integer, String> node = it.next();
                Integer key = node.getKey();
                String value = node.getValue();
                System.out.println(key + "=" + value);
            }
//        for (JavaseStudy.Map.Entry<Integer,String> m:s  // �������ϴ�ʱ���ô˷�ʽ����Ч�ʽϸ�
//             ) {
//            System.out.println(m.getKey()+"------>"+m.getValue());
//        }
        }
}
