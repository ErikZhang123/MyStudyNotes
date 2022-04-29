package DateClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*java.text����Ҫ�����ʽ����������
 *DateFormat��java.text���µģ����ڸ�ʽ����������
 *�����Ѿ���ʱ��toString��������ʱ����������Ҫ�ķ�ʽ��ʾ
 *DateFormatΪ�����࣬����Ҫ��������SimpleDateFormat��ʵ��
 *
 *���췽����
 *�޲ι���
 *�вι��죺SimpleDateFormat��String pattern��
 *��������д��Ӧ��ĸ����ɵĸ�ʽ���磺yyyy��MM��dd�� HH:mm:ss z
 *������ĸ��ʾ��Javaseѧϰ�ʼǣ���API
 *
 * ��ʽ�� SimpleDateFormat.format��Date����ת����Ϊ������Ҫ���ַ�������
 * ���� SimpleDateFormat.parse�������е��ַ�������ת����Date����
 * */
public class DateFormat {
    public static void main(String[] args) throws ParseException {
//	method1();
	method2();
    }

    public static void method2() throws ParseException {
        //�вι���
        //��ʽ��
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss z");
        Date d2 = new Date();
        System.out.println(sdf.format(d2));
        //����

        d2=sdf.parse("2020��7��14�� 1:00:00 CST");
        System.out.println(d2);
    }

    public static void method1() throws ParseException {
        //�޲ι���
        //	��ʽ��
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date d = new Date();
        System.out.println(sdf.format(d));
        //	����
        d=sdf.parse("2017-6-5 ����3:00");//��ʹ���޲ι���ʱ�����м�����á�-�������������������������������о�����
        System.out.println(d);
    }
}