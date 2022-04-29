package CollectionAndGeneric.Iterator;

import java.util.*;

/*
*  涉及到迭代器的增删时需要用迭代器的方法增删，或者集合增删完后刷新迭代器
 * 否则会抛出并发修改异常
* */
public class ConcorrentModificationException {
    public static void main(String[] args) {
        Collection<String> obj = new LinkedList<>();
        obj.add("1");
        obj.add("2");
        obj.add("3");
//       Iterator it = obj.iterator();     //该代码会跳出并发修改异常
//        obj.add("e");
//        while(it.hasNext())
//        {
//            System.out.println(it.next());
//        }
//        解决方法一：使用toArray将其变为数组，然后再更改输出
        Object[] o = obj.toArray();
        for(int i=0;i<o.length;i++)
        {
            if(o[i].equals("3"))
                obj.add("4");
        }
        System.out.println(obj);

//    方法二：由于Iterator没有添加功能，所以我们使用其List.ListIterator子类接口的方法
        List<String> l = new ArrayList<String>();
        l.add("a");
        l.add("b");
        ListIterator<String> listIterator = l.listIterator();
        while(listIterator.hasNext())
        {
            String str = listIterator.next();
            if(str.equals("b"))
            {
                listIterator.add("c");
            }
            System.out.println(str);
//            使用listIterator修改的数据仅修改正本集合，并不修改迭代器集合
//            若希望迭代器输出修改后的数据，则需要重新刷新迭代器
        }
        System.out.println(l);
    }
}
