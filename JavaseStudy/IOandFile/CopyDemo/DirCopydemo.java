package IOandFile.CopyDemo;


import java.io.*;
/*
*
* 将整个文件拷贝
*
* 技术总结：
* 1、在写项目的时候不要拿到手就开始写，首先需要整理归纳出逻辑和方法，然后用面向对象的思想
* 不要用面向过程的思维
* 2、在遇到如反复查询，或者其他闭环任务情况时首先考虑递归
* 3、FileInputStream是可以以File文件作为读取的。
* 4、boolean mkdir()与boolean mkdirs()的区别在于，前者只能创建一级目录，而后者可以一次创建多层目录
* 5、读取时，所创建的数组并不是越大越好，数组越大其读取时间也会越长所以应取合适地数组大小
* */

public class DirCopydemo {
    public static void main(String[] args) throws FileNotFoundException {
        File srcFile = new File("E:\\test");//E:\去掉，所以是从第3个字符
         File destFile = new File("E:\\copy");
        //第272集示范代码有个bug：当源目录为根目录时，如果根目录存在文件，则会导致无法在目标目录下创建与源目录名字相同的根目录，会导致异常。
        //因此必须先行判断源目录是否在目标目录下已经存在目录
        File flag = new File(destFile.getAbsoluteFile()+srcFile.getAbsolutePath().substring(3));
        if(!flag.exists())
            flag.mkdirs();
        copyDir(srcFile,destFile);
    }
    public static void copyDir(File srcFile,File destFile) {
        if(srcFile.isFile())
        {
            FileInputStream in = null;
            FileOutputStream out = null;
            try{//文件的边读边写
                byte[] b = new byte[1024*1024];//数组并不是越大越好，数组越大其读取时间也会越长
                int readCount = 0 ;
                in = new FileInputStream(srcFile);
                String scrDir = srcFile.getAbsolutePath();
                String path = (destFile.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() : destFile.getAbsolutePath()+ "\\")+scrDir.substring(3);
                out = new FileOutputStream(path);
                while((readCount=in.read(b))!=-1)
                {
                    out.write(b,0,readCount);
                }
                out.flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally
            {
                try {
                    if(out!=null)
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if(in!=null)
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return;
        }

        File[] files = srcFile.listFiles();
        for (File file :files) {
//            System.out.println(file.getAbsolutePath());
            if (file.isDirectory()) {
                String scrDir = file.getAbsolutePath();
                String destDir = destFile.getAbsolutePath().endsWith("\\") ? destFile.getAbsolutePath() : destFile.getAbsolutePath() + "\\" + scrDir.substring(3);
                //将根目录前的盘符去掉,与目标路径拼接
                //前面的目标路径不能写死，因此使用destFile的绝对路径
                //但在读取的时候可能会出现最后"\\"字符被省略的情况，因此需要用三项表达式判断。
                File newfile = new File(destDir);
                if (!newfile.exists()){
                    newfile.mkdirs();
                }
            }
            copyDir(file,destFile);//用递归，读取到遍历的每个目录下的所有目录
                //找到目录中的所有目录
                //使用递归的方法重复查找目录
                //直到查找到文件则返回上级目录查找第二个目录，以此类推
                //递归思想很重要，但凡涉及到闭环任务，都要使用递归
        }
    }
}
