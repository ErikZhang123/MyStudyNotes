package JavaseStudy.IOandFile.CopyDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class copydemo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        byte[] b = new byte[1024*1024];
        int readCount;
        try {
            fis = new FileInputStream("C:\\Users\\10593\\Desktop\\文件\\出国资料\\ucla资料.zip");
            fos = new FileOutputStream("E:\\copy\\ucla资料.zip");
            while((readCount=fis.read(b)) !=-1)
            {
                fos.write(b,0,readCount);
            }
            fos.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally
        {   //  分开try是为了防止在try时fis直接跳入EXception导致无法关闭fos
            try {
                if(fis!=null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos!=null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("复制完成");
        }
    }
}
