package CollectionAndGeneric.Iterator;

import java.util.*;

/*
*  �漰������������ɾʱ��Ҫ�õ������ķ�����ɾ�����߼�����ɾ���ˢ�µ�����
 * ������׳������޸��쳣
* */
public class ConcorrentModificationException {
    public static void main(String[] args) {
        Collection<String> obj = new LinkedList<>();
        obj.add("1");
        obj.add("2");
        obj.add("3");
//       Iterator it = obj.iterator();     //�ô�������������޸��쳣
//        obj.add("e");
//        while(it.hasNext())
//        {
//            System.out.println(it.next());
//        }
//        �������һ��ʹ��toArray�����Ϊ���飬Ȼ���ٸ������
        Object[] o = obj.toArray();
        for(int i=0;i<o.length;i++)
        {
            if(o[i].equals("3"))
                obj.add("4");
        }
        System.out.println(obj);

//    ������������Iteratorû����ӹ��ܣ���������ʹ����List.ListIterator����ӿڵķ���
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
//            ʹ��listIterator�޸ĵ����ݽ��޸��������ϣ������޸ĵ���������
//            ��ϣ������������޸ĺ�����ݣ�����Ҫ����ˢ�µ�����
        }
        System.out.println(l);
    }
}
