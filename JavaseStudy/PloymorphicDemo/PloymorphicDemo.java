package PloymorphicDemo;
/*
* ��̬��ǰ�᣺
* ����̳и���
* ������д
* ��������ָ���������
*
* ����/��ת��
* */
public class PloymorphicDemo {
    public static void main(String[] args) {
        Animal a = new Dog();//����ת�ͣ������ұߵ�������ʱ����Ϊ����
        //java���ȡ��߸����еķ���������ȣ�������������еķ������ܱ�����
        a.doSome();
        System.out.println(a.tpye);
        Dog d = (Dog)a;//����ת�ͣ������ұߵĸ�����ʱתΪ����
        //����ת���з��ա���ת��˫����û�м̳й�ϵ��ʱ��ᱨ��ClassCastException
//        �磺Cat c = (Cat) a;

    }
}

