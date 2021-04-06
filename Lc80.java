package leetcode;

/**
 * @author Kuma
 * @date 2021年4月6日
 * 80.删除有序数组中的重复项 II
 */
public class Lc80 {
    public int removeDuplicates(int[] nums) {
        return remove(nums,2);
    }
    public int remove(int[] nums,int k){
        int i = 0;
        for (int j : nums){
            if (i < k || nums[i - k] != j){
                nums[i++] = j;
            }
        }
        return i;
    }
}
