package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kuma
 * @date 2021年2月27日
 * 395.至少有K个重复字符的最长子串
 */
public class Lc395 {
    public int longestSubstring(String s, int k) {
        if (s.length() < k){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        for (char i : c){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Character, Integer> i : map.entrySet()){
            if (i.getValue() < k){
                int res = 0;
                for (String str : s.split(i.getKey() + "")){
                    res = Math.max(res, longestSubstring(str, k));
                }
                return res;
            }
        }
        return s.length();
    }
}
