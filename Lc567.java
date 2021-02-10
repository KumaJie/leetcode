package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kuma
 * @date 2021年2月10日
 * 567. 字符串的排列
 */
public class Lc567 {
    public static boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        int left = 0;
        int right = len - 1;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        Map<Character,Integer> mapToS2 = new HashMap<>();
        for (int i = left; i < right; i++) {
            char c = s2.charAt(i);
            mapToS2.put(c,mapToS2.getOrDefault(c,0) + 1);
        }
        while (right < s2.length()){
            char c = s2.charAt(right);
            mapToS2.put(c,mapToS2.getOrDefault(c,0) + 1);
            if(map.equals(mapToS2)){
                return true;
            }
            char l = s2.charAt(left);
            mapToS2.put(l,mapToS2.getOrDefault(l,0) - 1);
            if(mapToS2.get(l) == 0){
                mapToS2.remove(l);
            }
            left++;
            right++;
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "ad";
        String b = "eidbaooo";
        System.out.println(checkInclusion(a,b));
    }
}
