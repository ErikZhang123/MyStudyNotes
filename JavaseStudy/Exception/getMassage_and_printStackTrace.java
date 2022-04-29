package Exception;



public class getMassage_and_printStackTrace {
    public static void main(String[] args) {
//        getMessage会提取创建的异常对象的字符串信息
        NullPointerException e = new NullPointerException("空指针异常");
        String s = e.getMessage();
        System.out.println(s);
        System.out.println(1/0);
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}

