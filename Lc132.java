package leetcode;

import java.util.Arrays;

/**
 * @author Kuma
 * @date 2021年3月8日
 * 132. 分割回文串 II
 * 长度较长不适用递归记忆化，故采用普通数组
 */
public class Lc132 {
    public int minCut(String s) {
        int n = s.length();
//        i到j是否是回文串
        boolean[][] isP = new boolean[n][n];
        for (boolean[] i : isP){
            Arrays.fill(i, true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                isP[i][j] = isP[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
//        以i为结尾的子字符串分割所需最少次数
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (isP[0][i]){
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (isP[j + 1][i]){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}
