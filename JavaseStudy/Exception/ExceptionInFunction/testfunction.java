package Exception.ExceptionInFunction;

public class testfunction {
    public testfunction() {
    }

    public void fun() throws TestException {
        for(int i=1;i<10;i++)
        {
            if(i==5)
            {
                throw  new TestException("这是异常");
                //
            }
            System.out.println("这是第"+i+"个数字");
        }
    }
}
