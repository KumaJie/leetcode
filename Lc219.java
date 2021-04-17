package leetcode;

import java.util.HashSet;

/**
 * @author Kuma
 * @date 2021年4月17日
 * 219.存在重复元素 II
 */
public class Lc219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
