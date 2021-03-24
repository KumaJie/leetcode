package leetcode;

import java.util.Stack;

/**
 * @author Kuma
 * @date 2021年3月24日
 * 456.132 模式
 */
public class Lc456 {
    public boolean find132pattern(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (min < nums[j] && nums[j] < nums[i]){
                    return true;
                }
            }
            min = Math.min(min, nums[i]);
        }
        return false;
    }
}
