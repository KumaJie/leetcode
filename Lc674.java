package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kuma
 * @date 2021年1月24日
 * 674.最长连续递增序列
 */
public class Lc674 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]){
                result[i] += result[i - 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i : result){
            if(i > max){
                max  = i;
            }
        }
        return max;
    }
}
