package JavaseStudy.Exception.TryCatch;
/*
 * finally 中的语句会在最后执行，且一定会执行。即使try中的语句出现了异常也会执行
 * finally必须和try...catch一起出现
 * 除了system.exit能让finally不执行
 * */
public class FinallyDemo {
    public static void main(String[] args) {
        //try语句可以没有catch，直接跟finally子句
        //但是try不能单独使用。
        try{
            System.out.println("try...");
            return;//即使此处有return，但是finally还是会执行。
            //因为java实际上是先执行try中的语句，检测到return后先执行finally中的语句再执行return的
        }finally{
            System.out.println("finally...");
        }
        //此处不能写语句了，因为此处已经return了，代码不能执行到了
//        System.out.println("JavaseStudy.helloworld");
    }
}
