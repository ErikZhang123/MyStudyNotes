package Map.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PutAndGet {
    /*
     * 重点需要掌握HashMap中get和put方法的原理、
     * */
        public static void main(String[] args) {
            Map<String,String> map=new HashMap<>();
            map.put("张三","18");
            /*在调用put方法的时候
             * 首先会封装k,v 到Node对象
             * 使用k的hashCode方法计算出hash值，将其转换成下标
             * 如果对应位置没有元素，则将Node加入到该位置
             * 如果对应位置有元素，则用key和已存在的链表上的所有key比较，
             * 有相同key则覆盖value；
             * 没有则在链表末尾加上新的Node；
             * */
            map.put("张三","18");
            map.put("李四","18");
            map.put("王五","20");
            map.put("张三","22");//当key相同时，新的value会将旧的value覆盖掉
            //遍历方法一：通过entrySet方法将map集合转换成Set集合
            Set<Map.Entry<String,String>> s = map.entrySet();
            Iterator<Map.Entry<String,String>> it = s.iterator();
//        JavaseStudy.foreach.foreach
            for (Map.Entry<String ,String> node:s
            ) {
                System.out.println(node.getKey()+"-------->"+node.getValue());
            }
            //以上方法适合在大数据的时候使用，效率较高
//        因为node对象里面就有key和value的属性，所以不用通过key去找value

//        迭代器：
//        while(it.hasNext())
//        {
//            JavaseStudy.Map.Entry<Integer,String> node = it.next();
//            Integer key = node.getKey();
//            String value = node.getValue();
//            System.out.println(key+"="+value);
//        }


            //方法二：通过将key取出，称为Set集合，去遍历value
            Set<String> keys = map.keySet();
            //迭代器：
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
