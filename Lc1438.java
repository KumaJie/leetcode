package leetcode;

import java.util.TreeMap;

/**
 * @author Kuma
 * @date 2021年2月21日
 * 1438. 绝对差不超过限制的最长连续子数组
 */
public class Lc1438 {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int right = 0;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int res = 0;
        while (right < nums.length){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit){
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
