package leetcode;

/**
 * @author Kuma
 * @date 2021年4月14日
 * 33.搜索旋转排序数组
 */
public class Lc33 {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (right == -1){
            return -1;
        }
        if (right == 0){
            return nums[right] == target ? right : -1;
        }
        int mid;
        while (left <= right){
            mid = (right + left) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[0] <= nums[mid]){
                if (nums[0] <= target && target < nums[mid]){
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
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {4,5,6,7,0,1,2};
        System.out.println(search(a, 0));
    }
}
