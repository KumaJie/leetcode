package leetcode;

/**
 * @author Kuma
 * @date 2021年2月4日
 * 714. 买卖股票的最佳时机含手续费
 */
public class Lc714 {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1],dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
