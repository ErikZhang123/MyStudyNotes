package CollectionAndGeneric.List.Linklist;

import java.util.Iterator;

/*
* LinkedList没有下表
* LinkedList也没有初始化容量
* LinkedList实际上是由Node组成的，且包含first和last节点
* 每个Node由item，next，prev组成，对应元素内容，后节点地址，前节点地址
*
*
* */
public class LinkedListdemo {
    public static void main(String[] args) {
        java.util.LinkedList<String> l = new java.util.LinkedList<>();
        l.add("a");//add方法中首先会新建节点，然后更新尾节点，接着判断是否为头结点
//        是则更新头结点，否则将this.last.next更新为新节点的地址
        l.add("b");
        l.add("c");
        l.add("d");
        Iterator<String> i = l.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
        
        l.add("e");
        Iterator<String> i2 = l.iterator();
        while(i2.hasNext())
        {
            System.out.println(i2.next());
        }

    }
}
