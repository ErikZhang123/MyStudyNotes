import org.junit.Test;

import java.util.Scanner;

class test01
{
  public static void main(String[] args)
    {
        int[][] a = {{1,5,6},{10,3,22},{7,8,9}};
        System.out.println(test01(a));
    }


    public static int test01(int[][] metrix ){
        int sum = 0;
        int n = metrix.length;
        int m = metrix[0].length;
        int i =0 ; int j =0;
        int a,b,c;
        a = metrix[i][j];
        while( i != n-1 || j !=m-1 ){

            if (i+1 >= n && j+1 < m){//到达下界，只能往右
                sum = sum + a;
                a = metrix[i][j+1];
                j++;
                continue;
            }
            else if (i+1 < n && j+1 >= m){//到达右边界，只能往下
                sum = sum + a;
                a = metrix[i+1][j];
                i++;
                continue;
            }else if (i+1 <= n-1 && j+1 <= m-1){
                b = metrix[i+1][j];//向下
                c = metrix[i][j+1];//向右
                sum = sum + a;
                if( (a+b) < (a+c) || j+1>m-1){
                    a = b;
                    i++;
                    continue;
                }
                else if (a + c < a+b || i+1 > n-1){
                    a = c;
                    j++;
                    continue;
                }
            }
        }
        sum=sum+a;
        return sum;
    }
}
