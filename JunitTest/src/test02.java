import java.util.*;


public class test02 {
    public static void main(String[] args) {
        int[][] map = new int[2][2];
        for(int i = 0 ; i < map.length;i++){
            for(int j = 0 ; j < map[0].length ;j++){
                map[i][j] = j;
            }
        }
        int result = search(map);
        System.out.println(result);
    }

    public static int search(int[][] map){
        int[][] dp = new int[map.length][map[0].length];
        for(int i = 0 ; i < dp.length ; i++){
            dp[0][i] = map[0][i];
        }
        int result = 0;
        int temp = 0 ;

        for(int j = 1 ; j < map.length;j++) {
            for (int z = 0; z < map[0].length; z++) {
                if (z == 0) {
                    dp[j][z] = map[j][z] + Math.max(dp[j - 1][z], dp[j - 1][z + 1]);
                } else if (z == map[0].length - 1) {
                    dp[j][z] = map[j][z] + Math.max(dp[j - 1][z], dp[j - 1][z - 1]);
                } else {
                    dp[j][z] = map[j][z] + Math.max(dp[j - 1][z], Math.max(dp[j - 1][z - 1], dp[j - 1][z + 1]));
                }
            }
        }
        for(int i = 0 ; i < dp[0].length;i++){
            result = Math.max(dp[dp.length-1][i],result);
        }

        return result ;
    }
}
