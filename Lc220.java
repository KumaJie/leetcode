package leetcode;

import java.util.TreeSet;

/**
 * @author Kuma
 * @date 2021年4月17日
 * 220.存在重复元素 III
 */
public class Lc220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int left = 0;
        int right = 0;
        TreeSet<Long> set = new TreeSet<>();
        int n = nums.length;
        while (right < n){
            if (right - left > k){
                set.remove((long)nums[left]);
                left++;
            }
            Long ceiling = set.ceiling((long)nums[right] - (long)t);
            if (ceiling != null && Math.abs(ceiling - nums[right]) <= t) {
                return true;
            }
            set.add((long)nums[right]);
            right++;
        }
        return false;
    }
}
