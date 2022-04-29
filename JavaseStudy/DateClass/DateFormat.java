package DateClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*java.text包主要用与格式化各类数据
 *DateFormat是java.text包下的，用于格式化日期数据
 *代替已经过时的toString方法，让时间以我们想要的方式显示
 *DateFormat为抽象类，所以要用其子类SimpleDateFormat来实现
 *
 *构造方法：
 *无参构造
 *有参构造：SimpleDateFormat（String pattern）
 *（）中填写对应字母所组成的格式，如：yyyy年MM月dd日 HH:mm:ss z
 *具体字母表示见Javase学习笔记，或API
 *
 * 格式化 SimpleDateFormat.format：Date对象转换成为我们需要的字符串对象
 * 解析 SimpleDateFormat.parse：将已有的字符串对象转换成Date对象
 * */
public class DateFormat {
    public static void main(String[] args) throws ParseException {
//	method1();
	method2();
    }

    public static void method2() throws ParseException {
        //有参构造
        //格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss z");
        Date d2 = new Date();
        System.out.println(sdf.format(d2));
        //解析

        d2=sdf.parse("2020年7月14日 1:00:00 CST");
        System.out.println(d2);
    }

    public static void method1() throws ParseException {
        //无参构造
        //	格式化
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date d = new Date();
        System.out.println(sdf.format(d));
        //	解析
        d=sdf.parse("2017-6-5 下午3:00");//在使用无参构造时日期中间必须用‘-’隔开，而不能用其他方法，所以有局限性
        System.out.println(d);
    }
}