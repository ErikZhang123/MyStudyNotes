package InnerClass;

public class InnerClassTest {
    public static void main(String[] args) {
        int a =10;
//        ���������ڲ������
        demo1 d = new demo1();
        demo1.eat g = d.new eat();
        String.valueOf("");
    }
}
class demo1
{

    private int b=100;
    private String name = "����";
    class eat//�ڲ��࣬��.class�ļ���$���ⲿ�����������
    {
        public void eating()
        {
            System.out.println(name+b);//�ڲ�����Ե����ⲿ�൱�еĳ�Ա�������Ƿ�Ϊprivate
        }
    }
}
