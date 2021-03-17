package leetcode;

import java.util.Arrays;

/**
 * @author Kuma
 * @date 2021年3月17日
 * 115.不同的子序列
 */
public class Lc115 {
    public int numDistinct(String s, String t) {
        char[] srr = s.toCharArray();
        char[] trr = t.toCharArray();
        int[][] dp = new int[trr.length + 1][srr.length + 1];
        Arrays.fill(dp[0],1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (trr[i - 1] == srr[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                }else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[trr.length][srr.length];

    }
}
