package CollectionAndGeneric.Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/*
* 涉及到迭代器的增删时需要用迭代器的方法增删，或者集合增删完后刷新迭代器
* 否则会抛出并发修改异常
* */
public class IteratorRmove {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("a");
        c.add("b");
        c.add("c");
        c.add("d");
        c.add("e");
//        Iterator it = c.iterator();     //该代码会跳出并发修改异常
//        c.remove("a");
//        while(it.hasNext())
//        {
//            System.out.println(it.next());
//        }
//        解决方法：使用迭代器的remove方法
        Iterator it = c.iterator();
        while(it.hasNext())
        {
            Object o = it.next();
            if(o.equals("d")) {
                it.remove();//注意，在使用remove之前必须先使用iterator.next()获取元素，
                // 否则无法指定元素，报异常：IllegalStateException
            }
            else
                System.out.println(o);
        }

    }
}
