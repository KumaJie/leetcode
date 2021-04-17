package leetcode;

import java.util.TreeSet;

/**
 * @author Kuma
 * @date 2021年4月17日
 * 220.存在重复元素 III
 */
public class Lc220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceil = set.ceiling((long)nums[i] - (long)t);
            if (ceil != null && ceil <= (long)nums[i] + (long)t){
                return true;
            }
            set.add((long)nums[i]);
            if (i >= k){
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}
