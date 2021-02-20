package leetcode;

import java.util.*;

/**
 * @author Kuma
 * @date 2021年2月20日
 * 697.数组的度
 */
public class Lc697 {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            if (!left.containsKey(tmp)) {
                left.put(tmp, i);
            }
            right.put(tmp, i);
        }
        //      nums的度
        int du = Collections.max(map.values());
        int res = nums.length;
        for (Map.Entry<Integer, Integer> m : map.entrySet()){
            if (m.getValue() == du){
                int key = m.getKey();
                res = Math.min(res, right.get(key) - left.get(key) + 1);
            }
        }
        return res;
    }
}
