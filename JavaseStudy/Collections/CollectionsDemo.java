package Collections;

import java.util.*;

/*
*
* Collections是一个工具类，他与Collection不一样
* 主要方法：
* 1、collections.sort();对集合进行排序
* 对list中元素排序时要保证List中元素实现Comparable接口
* 对Set集合排序的时候要将其转换成List集合。
*
* 2、collections.sychronizedList(list);
*将原本非线程安全的list转换成线程安全的
* */
public class CollectionsDemo {
    public static void main(String[] args) {
        Collection<Integer> set = new HashSet<>();
        set.add(112);
        set.add(3786);
        set.add(4354);
        set.add(6786);
        set.add(5345);
        set.add(777);
        set.add(5543);
        set.add(543);
        System.out.println(set);//无序输出
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println(list);

        Collection<String> str = Collections.synchronizedList(new ArrayList<String>());
        str.add("a");
        str.add("b");

    }
}
