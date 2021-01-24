package leetcode.zhousai;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kuma
 * @date 2021年1月24日
 * 5662.满足三条件之一需改变的最少字符数
 */
public class Lczs5662 {
    public static int minCharacters(String a, String b) {
        char maxA = 'a' - 1;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) > maxA){
                maxA = a.charAt(i);
            }
        }
        char maxB = 'a' - 1;
        for (int i = 0; i < b.length(); i++) {
            if(b.charAt(i) > maxB){
                maxB = b.charAt(i);
            }
        }
        int result = 0;
        // 条件一
        int sum = 0;
        for (int i = 0; i < b.length(); i++) {
            if(b.charAt(i) <= maxA){
                sum++;
            }
        }
        result = sum;
        sum = 0;
        // 条件二
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) <= maxB){
                sum++;
            }
        }
        result = Math.min(result,sum);
        // 条件三
        int[][] dp = new int[a.length()+1][b.length()+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i == 0) {
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }else{
                    if(a.charAt(i - 1) == b.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }else {
                        dp[i][j] = Math.min(dp[i][j - 1] + 1,dp[i - 1][j] + 1);
                        dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j]);
                    }
                }
            }
        }
        sum = dp[a.length()][b.length()];
        result = Math.min(sum,result);
        return result;
    }

    public static void main(String[] args) {
        int s = minCharacters("horse","ros");
        System.out.print(s);
    }
}
