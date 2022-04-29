package Map.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PutAndGet {
    /*
     * �ص���Ҫ����HashMap��get��put������ԭ��
     * */
        public static void main(String[] args) {
            Map<String,String> map=new HashMap<>();
            map.put("����","18");
            /*�ڵ���put������ʱ��
             * ���Ȼ��װk,v ��Node����
             * ʹ��k��hashCode���������hashֵ������ת�����±�
             * �����Ӧλ��û��Ԫ�أ���Node���뵽��λ��
             * �����Ӧλ����Ԫ�أ�����key���Ѵ��ڵ������ϵ�����key�Ƚϣ�
             * ����ͬkey�򸲸�value��
             * û����������ĩβ�����µ�Node��
             * */
            map.put("����","18");
            map.put("����","18");
            map.put("����","20");
            map.put("����","22");//��key��ͬʱ���µ�value�Ὣ�ɵ�value���ǵ�
            //��������һ��ͨ��entrySet������map����ת����Set����
            Set<Map.Entry<String,String>> s = map.entrySet();
            Iterator<Map.Entry<String,String>> it = s.iterator();
//        JavaseStudy.foreach.foreach
            for (Map.Entry<String ,String> node:s
            ) {
                System.out.println(node.getKey()+"-------->"+node.getValue());
            }
            //���Ϸ����ʺ��ڴ����ݵ�ʱ��ʹ�ã�Ч�ʽϸ�
//        ��Ϊnode�����������key��value�����ԣ����Բ���ͨ��keyȥ��value

//        ��������
//        while(it.hasNext())
//        {
//            JavaseStudy.Map.Entry<Integer,String> node = it.next();
//            Integer key = node.getKey();
//            String value = node.getValue();
//            System.out.println(key+"="+value);
//        }


            //��������ͨ����keyȡ������ΪSet���ϣ�ȥ����value
            Set<String> keys = map.keySet();
            //��������
            Iterator it2 = keys.iterator();
            while(it2.hasNext())
            {
                String key = (String) it2.next();
                String value = map.get(key);
                System.out.println(key+"=="+value);
            }
//        JavaseStudy.foreach.foreach
            for (String s1 :keys
            ) {
                System.out.println(s1+"======"+map.get(s1));
            }

        }
}
