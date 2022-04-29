package CollectionAndGeneric.Set.TreeSet;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
/*
* TreeSet底层是二叉树结构，其实际上与TreeMap类似，都继承与SortedMap。
* TreeSet中的元素无序不可重复，但会按照元素大小自动排序，若元素为自建类则需要定义Comparator或者实现Comparable接口方法
* 如果自建类不实现Comparable或者不定义Comparator，则会抛异常ClassCastException.
* TreeSet中的equals方法可以不重写
*
* 对于自动包装类和String而言有默认排序规则
* String 类型按照字典顺序排序
* Integer类型按照数字大小
* */
public class TreeSetdemo {
    public static void main(String[] args) {
//        Set<Integer> s = new TreeSet<>();
//        s.add(100);
//        s.add(200);
//        s.add(40);
//        s.add(55);

        Set<String> s = new TreeSet<>();
        s.add("cde");
        s.add("abd");
        s.add("abc");
        s.add("acd");
        s.add("aef");
        s.add("bbd");
        Iterator<String> i =s.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }

    }
}
