package leetcode;

/**
 * @author Kuma
 * @date 2021年4月15日
 * 213.打家劫舍 II
 */
public class Lc213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1){
            return nums[0];
        }else if (n == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robSum(nums,0, n - 2), robSum(nums,1, n - 1));
    }

    public int robSum(int[] nums, int left ,int right){
        //        滚动数组
        int first = nums[left];
        int second = Math.max(first, nums[left + 1]);
        for (int i = left + 2; i <= right; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }
        return second;
    }
}
