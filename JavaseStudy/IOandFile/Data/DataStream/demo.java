package IOandFile.Data.DataStream;

public class demo {
    /*
    * 数据流 DataInput/OutputSream
    * 其是将数据与数据类型一起写入文件
    * 该文件不是普通的文件，因此不能用文本打开
    * 构造方法：
    * DataOutputStream dos = new DataOutputStream(new FileInputStream("a"));
    *
    * 数据流输出的文件只能用数据流读取，并且必须知道其写入时的顺序才能正确读取，否则就是乱码
    * 比如：
    *                           输出代码：
    * int i=0;                  dos.writeInt
    * boolean flag = true;      dos.writeBoolean
    * .
    * .
    * .
    *
    * */
}
