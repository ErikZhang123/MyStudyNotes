package CollectionAndGeneric.Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
* Iterator是迭代器，用来遍历Collection集合及其子类集合
* 语法：
* Iterator<E> i = Collection.iterator();创建Iterator对象
*
* 主要方法：
* boolean hasNext();作为遍历结束的条件，判断是否有下一个元素
* Object next();用来返回迭代的下一个元素
* 如果直接使用next()，若下一个元素为null则会报错
* NoSuchElementException
* */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("张三");
        c.add("李四");
        c.add("王五");
        Iterator<String> i = c.iterator();
       while(i.hasNext())
       {
           System.out.println(i.next());
       }

    }
}
