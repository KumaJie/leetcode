package leetcode;

/**
 * @author Kuma
 * @date 2021年4月15日
 * 198.打家劫舍
 */
public class Lc198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0){
            return 0;
        }else if (n == 1){
            return nums[0];
        }
//        滚动数组
        int[] dp = new int[3];
        dp[1] = nums[0];
        dp[2] = Math.max(dp[1], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[0] = dp[2];
            dp[2] = Math.max(dp[1] + nums[i], dp[2]);
            dp[1] = dp[0];
        }
        return dp[2];
    }
}
