package Map.HashMap;
/*
* HashMap以键值对方式存储（k,v）
* k和v都是引用数据类型
* k和v都存储对象的内存地址
* key起主导作用，value是key的附属品
* HashMap的key元素就是放到HashSet中了
*
* Hash表实际上是单向链表和数组的结合体
*
* 注意点：HashMap集合的默认初始容量为16，默认加载因子为0.75；
* 其初始化容量必须是2的倍数，扩容以后是原容量的2倍。
* 上述注意点是能够让HashMap更容易达到散列分布均匀，提高存取效率。
*
* HashMap底层数据无序且不可重复
* 无序是由于不知道放到那个下标上
* 不可重复是因为其会调用equals方法来保证数据不重复，所以在使用自建类的时候必须要重写equals和hashCode方法
* 由于 HashMap的key元素就是放到HashSet中了，所以HashSet中的元素也要重写equals方法
* */
public class HashMap<S, S1> {
    public static void main(String[] args) {

    }
}
