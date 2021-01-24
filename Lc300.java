package leetcode;

/**
 * @author Kuma
 * @date 2021年1月24日
 * 300.最长递增子序列
 */
public class Lc300 {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] > nums[j - 1]){
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
        }
        int max = 0;
        for (int i : dp){
            if(i > max){
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {10,9,2,5,3,7,101,18};
        int s = lengthOfLIS(a);
        System.out.println(s);
    }
}
