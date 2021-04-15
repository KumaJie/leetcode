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
        int first = nums[0], second = Math.max(first, nums[1]);
        for (int i = 2; i < n; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }
        return second;
    }
}
