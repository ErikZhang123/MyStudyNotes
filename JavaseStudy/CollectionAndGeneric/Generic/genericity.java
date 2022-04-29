package CollectionAndGeneric.Generic;
/*
* 泛型：使用泛型以后原本直接继承Object的集合：如ArrayList等就只能存储泛型的元素
*
* 泛型只在编译期起作用，在运行期不起作用
* JDK8后提供了类型自动推断功能，即钻石表达式，
* eg：List<Student> mylist = new ArrayList<>();
* 右边的泛型类型会自动和左边匹配。
*
* 泛型的优点：
* 1、集合中存储元素的类型统一了
* 2、从集合中去除的元素类型是泛型指定类，不用大量向下转型了
* 缺点：
* 减少了集合元素多样性，不能随意存储元素
*
* 但是我们在创建集合的时候尽量写上泛型，以避免可能出现的ClassCastException
*
* */
public class genericity {
    public static void main(String[] args) {
        genericityTest<String> genericityTest=new genericityTest<>();//此处new的对象泛型只与此时所写的泛型有关
        //与自定义泛型中的标题标识符无关
        genericityTest.doSome("fuckyou");
    }
    /*自定义泛型*/
    public static class genericityTest<safuhsdoiguhdas>//此处标识符可以为任意，不影响main中泛型
    {
    public void doSome(safuhsdoiguhdas safuhsdoiguhdas)
    {
        System.out.println(safuhsdoiguhdas);
    }
    }
}


