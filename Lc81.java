package leetcode;

/**
 * @author Kuma
 * @date 2021年4月14日
 * 81.搜索旋转排序数组 II
 */
public class Lc81 {
    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (right == -1){
            return false;
        }
        if (right == 0){
            return nums[right] == target;
        }
        int mid;
        while (left <= right){
            mid = (right + left) / 2;
            if (nums[mid] == target){
                return true;
            }else if (nums[left] == nums[right]){
                left++;
            }else if (nums[left] <= nums[mid]){
                if (nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if (nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,0,1,1,1};
        search(a,0);
    }
}
