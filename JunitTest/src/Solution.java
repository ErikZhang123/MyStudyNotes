//数学老师说一个偶数总能表示为两个素数之和，小明表示怀疑，请编写程序求出可以表示偶数n的两个素数验证数学老师的结论。

// ############# java 模板 #################
//  n int (偶数)
// 返回值： 两个素数组成的数组
public class Solution {
    public static int[] findNumber(int n1) {
        /* 在这里编写你的程序  */
        for(int i =2; i< n1 ; i++) {
            if(isPrime(i) && isPrime( n1 -i)){
                return new int[]{i, n1-i};
            }
        }
        return new int[0];
    }

    public static boolean isPrime(int n ){
        if(n==1) return false;
        for (int i = 2; i*i <=n ; i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int n1 = 22;

        Solution result = new Solution();
        int[] s =result.findNumber(n1);
        System.out.println(s[0]+"and"+s[1]);
    }
}