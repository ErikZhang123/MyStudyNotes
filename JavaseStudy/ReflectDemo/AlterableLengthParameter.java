package ReflectDemo;
/**
 * �ɱ䳤�Ȳ�����
 * �﷨
 * public static void m(Object a,Object b,Object c,int..args)
 * main����ʹ�õ�ʱ��
 *          m();        ����
 *          m(a,b,c,10);
 *          m(a,b,c,10,2,30...)����
 *�ɱ䳤�Ȳ����Ĳ�������Ϊ��0~N����Nȡ������ʹ��ʱ����Ĳ�������
 * �ɱ䳤�Ȳ����ڲ����б���ֻ�ܳ���һ����ֻ�ܳ��������һλ
 * �ɱ䳤�Ȳ���������Ϊһ�����飬��Ϊargs��length���ԣ������±꣬����ʹ��args[i]���и�ֵ����
 * */
public class AlterableLengthParameter {
    public static void main(String[] args) {
        doSome("zhangsan1","lisi2","wangwu3","zhaoliu4");

    }
    public static void doSome(String ...name)
    {
        System.out.println(name.length);
         if(name[0].equals("zhangsan1"))
         {
             if(!name[2].isEmpty())
                 name[2]="shabi5";//�޸����ݳɹ�
         }
        for (String n:name
             ) {
            System.out.println(n);
        }
    }

}
