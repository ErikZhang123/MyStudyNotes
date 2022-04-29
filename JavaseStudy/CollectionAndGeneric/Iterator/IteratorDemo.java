package CollectionAndGeneric.Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
* Iterator�ǵ���������������Collection���ϼ������༯��
* �﷨��
* Iterator<E> i = Collection.iterator();����Iterator����
*
* ��Ҫ������
* boolean hasNext();��Ϊ�����������������ж��Ƿ�����һ��Ԫ��
* Object next();�������ص�������һ��Ԫ��
* ���ֱ��ʹ��next()������һ��Ԫ��Ϊnull��ᱨ��
* NoSuchElementException
* */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("����");
        c.add("����");
        c.add("����");
        Iterator<String> i = c.iterator();
       while(i.hasNext())
       {
           System.out.println(i.next());
       }

    }
}
