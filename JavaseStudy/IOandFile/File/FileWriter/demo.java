package JavaseStudy.IOandFile.File.FileWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class demo {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter(new File("�½��ı��ļ�2.txt"),true);
        //�ù��췽��ʹ�����������ļ��󸽼�д�룬����������ļ���д��
        fileWriter.write("����");
        fileWriter.flush();//flush��ˢ�»������������е�����ȫ�������
        fileWriter.close();//close��ֱ�ӹر��������ܵ������ݶ�ʧ��

    }
}
