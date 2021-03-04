package leetcode;

import java.util.Arrays;

/**
 * @author Kuma
 * @date 2021年1月24日
 * 300.最长递增子序列
 */
public class Lc300 {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {10,9,2,5,3,7,101,18};
        int s = lengthOfLIS(a);
        System.out.println(s);
    }
}
