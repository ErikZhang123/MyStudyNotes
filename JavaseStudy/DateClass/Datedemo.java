package DateClass;
import java.util.Date;
public class Datedemo {
    /*
     * Date���ʾ�ض�˲�䣬��ȷ�����롣
     * �Ǿ�̬����
     * ���췽����
     * 1��Date():����һ����ʾ��ǰϵͳʱ��Ķ���
     * 2��Date(long date):���ݡ�ָ��ʱ�䡱����Date��������һ������ֵ��Ȼ����1970-1-1��.0:00�Ļ����ϼ��Ϻ���ֵ�õ�������ض�ʱ��
     *
     * ͨ�����÷��У�
     * 1���Ѻ���ֵת��Ϊdate����
     * 	ͨ��set������ void setTime(long time)
     * 	Date(long date)
     * 2����Date����ת��Ϊ����ֵ
     * 	long getTime();
     * System.currentTimeMillis.��ȡϵͳ����19700101��0��00�ĺ���ֵ
     * */
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);//�����ǰϵͳʱ��
//	�Ѻ���ֵת��Ϊdate����
        d.setTime(1000*60*60*24);//void setTime(long time)����Ч����new  Date(long date)Ч��һ��
        System.out.println(d);
//	��Date����ת��Ϊ����ֵ
        Date d1 = new Date(1000*60*60*24);
        System.out.println(d1);
        System.out.println(d1.getTime());//��ȡ��1970.01.01,0��00��d1����ĺ�����
    }
}
