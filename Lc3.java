package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
*@author Kuma
*@date 2021年2月20日
*3. 无重复字符的最长子串
*/
class Lc3{
  public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()){
            char t = s.charAt(right);
            map.put(t, map.getOrDefault(t, 0) + 1);
            while (map.get(t) > 1){
                char h = s.charAt(left);
                map.put(h, map.get(h) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
