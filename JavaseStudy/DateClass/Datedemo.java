package DateClass;
import java.util.Date;
public class Datedemo {
    /*
     * Date类表示特定瞬间，精确到毫秒。
     * 非静态方法
     * 构造方法：
     * 1、Date():创建一个表示当前系统时间的对象。
     * 2、Date(long date):根据“指定时间”创建Date对象。输入一个毫秒值，然后在1970-1-1，.0:00的基础上加上毫秒值得到所求的特定时间
     *
     * 通常的用法有：
     * 1、把毫秒值转化为date对象
     * 	通过set方法， void setTime(long time)
     * 	Date(long date)
     * 2、把Date对象转化为毫秒值
     * 	long getTime();
     * System.currentTimeMillis.获取系统距离19700101，0：00的毫秒值
     * */
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);//输出当前系统时间
//	把毫秒值转化为date对象
        d.setTime(1000*60*60*24);//void setTime(long time)方法效果与new  Date(long date)效果一致
        System.out.println(d);
//	把Date对象转化为毫秒值
        Date d1 = new Date(1000*60*60*24);
        System.out.println(d1);
        System.out.println(d1.getTime());//获取从1970.01.01,0：00到d1对象的毫秒数
    }
}
