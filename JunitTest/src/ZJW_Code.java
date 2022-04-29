public class ZJW_Code {

    //输入三个字符串s1，s2，s3， s3是否是s1，s2交替得到的？
    public boolean test01(String s1,String s2,String s3){
        boolean[] flag = new boolean[s1.length()+1];//纵轴s1,横轴s2。
        boolean[] flag2 = new boolean[s2.length()+1];
        flag[0] = true;
        flag2[0] = true;
        for(int i=1;i<flag.length;i++){
            if(flag[i-1]){//如果上一个可以从s1中取，那当前是否也可以，如果也可以，那也从s1中获取。
                flag[i]= s1.charAt(i-1)==s3.charAt(i-1);
                //检查s3中的哪些字符在s1出现，在出现的位置标注,并且判断是否可以连续组成。
            }

        }
        System.out.println(flag);
        for(int i=1;i<flag2.length;i++){
            if(flag2[i-1]){
                flag2[i]=s2.charAt(i-1)==s3.charAt(i-1);
            }

        }
        System.out.println(flag2);
        //用二维数组的方式表示当前位置是否成立
        boolean[][] flag3 = new boolean[flag.length][flag2.length];

        for(int i=1;i<flag3.length;i++){
            flag3[i][0] = flag[i];
        }
        for(int i=1;i<flag3[0].length;i++){
            flag3[0][i] = flag2[i];
        }

        flag3[0][0]=true;

        for(int i=1;i<flag3.length;i++){
            for(int j=1;j<flag3[0].length;j++){
                flag3[i][j]=(flag3[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1))    ||
                        //当前在s3的第（i+j-1）的位置上，如果这个位置之前是由s1中获得的（flag[i][j-1]==0）
                        //那么检查 s2的当前元素是否与s3的当前元素相等，如果相等则到当前位置取true。
                        //比如flag3[2][3]是true，那么直到目前为止，s3可以使用交错表示，并且s1中的字符使用了一次，s2中的字符使用了两次
                            (flag3[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1));
                        //同理
            }
        }
        return flag3[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        ZJW_Code z = new ZJW_Code();
        System.out.println(z.test01("aaa","aaa","aaaaaaaaaa"));

    }
}
