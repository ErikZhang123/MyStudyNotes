package Wildcard;
import java.util.*;
public class WildCardDemo {
}

class SumNumber{
    public static double sumNumbers(List<? extends Number> list){
        double sum = 0.0;
        for (Number n :list) {
            sum = sum + n.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumNumbers(
                Arrays.asList(new Integer[] {1,2,3,4,5,6})));

        System.out.println(sumNumbers(Arrays.asList(new Double[] {1.0,5.0,-10.0,2.0})));
    }
}