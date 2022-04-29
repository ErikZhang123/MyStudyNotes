package ReflectDemo;
/**
 * 可变长度参数：
 * 语法
 * public static void m(Object a,Object b,Object c,int..args)
 * main当中使用的时候：
 *          m();        可以
 *          m(a,b,c,10);
 *          m(a,b,c,10,2,30...)可以
 *可变长度参数的参数个数为从0~N个，N取决于在使用时输入的参数个数
 * 可变长度参数在参数列表中只能出现一次且只能出现在最后一位
 * 可变长度参数可以视为一个数组，因为args有length属性，且有下标，可以使用args[i]进行赋值操作
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
                 name[2]="shabi5";//修改数据成功
         }
        for (String n:name
             ) {
            System.out.println(n);
        }
    }

}
