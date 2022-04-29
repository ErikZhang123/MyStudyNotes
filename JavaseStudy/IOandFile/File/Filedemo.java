package IOandFile.File;

import java.io.File;
/*
File继承Object
File是文件和目录路径名的抽象表现形式
* */
public class Filedemo {
    public static void main(String[] args) {
        //构造方法
        File test = new File("E:\\test");
        File[] dir = test.listFiles();
        File copy = new File("E:\\copy\\a\\B\\C\\D");
        File trans = null;
        for(int i=0;i<dir.length;i++)
        {
            if(dir[i].isDirectory())
            {
                trans = new File(copy.getAbsoluteFile()+"\\"+dir[i].getName());
//                trans.mkdir();//当copy的地址为多级目录时无法使用mkdir，要使用mkdirs
                trans.mkdirs();
                System.out.println("创建成功");
            }
        }
//        copy.mkdir();//一次只能创建一层目录
//        copy.mkdirs();//可以一次创建多级目录
    }
}

