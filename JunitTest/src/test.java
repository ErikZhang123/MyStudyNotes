import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class test {
    public static void main(String[] args) {
       test t = new test();
       String s ="abba";
        System.out.println(t.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character,Boolean> map = new HashMap<>();
        char[] temp = s.toCharArray();
        int number=0;
        int maxlength=0;
        int j=0;
        int i=0;
        int point =0;
        boolean flag = true;
        if(temp.length <= 1)
            return temp.length;
        for(i=0;i<temp.length;i++) {
            if (!map.containsKey(temp[i])) {
                map.put(temp[i], true);
                if(!flag){
                    number = i-point;
                    if(maxlength<number)
                        maxlength=number;
                }
                else{
                    maxlength = i-point+1;
                }
            } else {
                flag = false;
                for(j=0;j<i;j++){
                    if(temp[j]==temp[i])
                        if(point < j)
                            point = j;
                }
                number = i-point;
                if (number > maxlength) {
                    maxlength = number;
                }
                number = 0;
            }
        }
        return maxlength;
    }
}
