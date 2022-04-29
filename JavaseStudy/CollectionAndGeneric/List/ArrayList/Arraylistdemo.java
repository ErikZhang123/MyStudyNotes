package CollectionAndGeneric.List.ArrayList;

import java.util.*;
/*ArrayList底层数据结构是Object[] 数组
注意：ArrayList数组是非线程安全的；
* 初始化容量为10；
* 扩容后的容量是原容量的1.5倍
* 扩容原理：将原容量转为二进制，将二进制后的数右移一位的数作为扩容的值。
* 扩容后容量=原容量+原容量/2；
* 但是由于其底层是数组，所以实际上扩容较复杂，尽量在建立集合时就设计一个较大的容量。
*
* */
public class Arraylistdemo {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<Integer>();
        System.out.println(list1.size());
        list1.add(1);
        System.out.println(10<<1);//二进制位移计算：>> 1 或<< 1 代表将左边的数字转化成二进制后往右/左移一位所得到的值

        Set<Integer> linklist;
        linklist = new HashSet<Integer>();
        linklist.add(1);
        List<Integer> list2 = new ArrayList<Integer>(linklist); //ArrayList第二种构造方法
        System.out.println(list1.get(1));

    }
}
