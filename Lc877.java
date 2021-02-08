package leetcode;

/**
 * @author Kuma
 * @date 2021年2月8日
 * 877.石子游戏
 */
public class Lc877 {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[] dp = new int[n];
        System.arraycopy(piles, 0, dp, 0, n);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j-1]);
            }
        }
        return dp[n-1] > 0;
    }
}
