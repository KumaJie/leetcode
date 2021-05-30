package leetcode;

/**
 * @author Kuma
 * @date 2021年5月30日
 * 153.寻找旋转排序数组中的最小值
 */
public class Lc153 {
    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j){
            int mid = i + j >> 1;
            if (nums[i] < nums[j]){
                break;
            }else {
                if (nums[mid] >= nums[i]){
                    i = mid + 1;
                }else {
                    j = mid;
                }
            }
        }
        return nums[i];
    }
}
