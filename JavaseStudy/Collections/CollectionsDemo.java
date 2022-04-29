package Collections;

import java.util.*;

/*
*
* Collections��һ�������࣬����Collection��һ��
* ��Ҫ������
* 1��collections.sort();�Լ��Ͻ�������
* ��list��Ԫ������ʱҪ��֤List��Ԫ��ʵ��Comparable�ӿ�
* ��Set���������ʱ��Ҫ����ת����List���ϡ�
*
* 2��collections.sychronizedList(list);
*��ԭ�����̰߳�ȫ��listת�����̰߳�ȫ��
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
        System.out.println(set);//�������
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println(list);

        Collection<String> str = Collections.synchronizedList(new ArrayList<String>());
        str.add("a");
        str.add("b");

    }
}
