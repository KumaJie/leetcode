package leetcode;

/**
 * @author Kuma
 * @date 2021年2月7日
 * 665.非递减数列
 */
public class Lc665 {
    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i - 1]){
                if(i == 1 || nums[i] >= nums[i - 2]){
                    nums[i - 1] = nums[i];
                }else {
                    nums[i] = nums[i - 1];
                }
                count++;
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        int[] a = {3,4,2,3};
        checkPossibility(a);
    }
}
