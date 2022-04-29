package Map.HashMap;

import java.util.Map;
import  java.util.HashMap;

/*
* Hashtable底层也是Hash表
* 但是Hashtable的key与value不能为null
* Hashtable是线程安全的，效率较低
* 主要是由于sychronized关键字会检查value与key是否为null
* 为null时会抛出NullPointException
*
* Hashtable初始化容量为11，默认加载因子为0.75
* 扩容后的容量=原容量*2+1；
*
* */
public class HashtableDemo {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(null,null);//HashMap的key和value都可以为null
        System.out.println(map.get(null));

//        JavaseStudy.Map map1 = new Hashtable();
//        map1.put(null,null); 由于synchronized保护，所以报错 NullPointerException
//        System.out.println(map1.get(null));
    }
}
