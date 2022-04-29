package JavaseStudy.Exception.TryCatch;

public class FinallyTest01 {
    public static void main(String[] args) {
        int result = m1();
        System.out.println(result);//输出100
    }
    /*java语法规则：
        方法体中的代码必须从上而下依次逐行执行
        return语句一旦执行，整个方法必须结束
    * */
    public static int m1()
    {
        int i = 100;
        try{
            //该代码出现在100下面，所以会返回100，但return的确是在finally之后执行的
            //实际上该代码执行的时候会如下所示
            /*
            int i=100;
            int j=i;
            i++
            return j;
            所以实际上它是符合java的语法规则的
            */
            return i;
        }finally
        {
            i++;
        }
    }

}
