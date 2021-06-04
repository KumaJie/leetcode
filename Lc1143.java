package leetcode;

/**
 * @author Kuma
 * @date 2021年6月4日
 * 1143.最长公共子序列
 */
public class Lc1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
//        滚动数组
        int[][] dp = new int[2][m + 1];
        for (int i = 1; i <= n; i++) {
            int cur = i & 1;
            int pre = cur ^ 1;
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[cur][j] = dp[pre][j - 1] + 1;
                 }else {
                    dp[cur][j] = Math.max(dp[pre][j], dp[cur][j - 1]);
                }
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[n & 1][m];
    }
}
