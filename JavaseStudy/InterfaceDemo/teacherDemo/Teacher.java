package InterfaceDemo.teacherDemo;

import java.sql.SQLOutput;

public class Teacher implements TeachingSubject,Sport,Sleep{
    boolean flag;
    public void study()throws StopTeachingException
    {
        System.out.println("??????");
        if (flag)
        {
            throw new StopTeachingException("?????????????????????");
        }
    }
    @Override
    public  void teaching()  {
    }

    @Override
    public void sleep() {

    }

    @Override
    public void play() {

    }


}
