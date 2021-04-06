package leetcode;

/**
 * @author Kuma
 * @date 2021年4月6日
 * 26.删除有序数组中的重复项
 */
public class Lc26 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        while (i < nums.length && j < nums.length){
            if (nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
            j++;
        }
        return i+1;
    }
}
