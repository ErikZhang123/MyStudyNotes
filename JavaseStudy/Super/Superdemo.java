package Super;
/*
* superֻ�ܳ�����ʵ�������͹��췽���У����ܳ����ھ�̬������
* �﷨��super �� super()
* ���ʱ��super����ʡ�ԣ������������з��ʸ���ͬ�������ʱ��super����ʡ��
* ����super.name��
* super()ֻ�ܳ����ڹ��췽���ĵ�һ�У�ͨ����ǰ���췽�����ø����е��������췽����
* ��Ŀ�����ڴ�����������ʱ���ȴ�������
* */
public class Superdemo {
    public static void main(String[] args) {
        Person p = new Student("����",18,"��");
        Student s = (Student)p;

    }
}
