package leetcode;

import java.util.HashMap;

/**
 * @author Kuma
 * @date 2021年6月3日
 * 525.连续数组
 */
public class Lc525 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int max = 0;
        for (int i = 2; i <= n; i++) {
            if (!map.containsKey(prefix[i - 2])){
                map.put(prefix[i - 2], i - 2);
            }
            if (map.containsKey(prefix[i])){
                max = Math.max(max, i - map.get(prefix[i]));
            }
        }
        return max;
    }
}
