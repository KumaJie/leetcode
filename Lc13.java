package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Kuma
 * @date 2021年5月15日
 * 13. 罗马数字转整数
 */
public class Lc13 {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        char[] ss = s.toCharArray();
        int n = ss.length;
        int i = 0;
        while (i < n - 1){
            if (map.get(ss[i]) >= map.get(ss[i + 1])){
                res += map.get(ss[i]);
            }else {
                res -= map.get(ss[i]);
            }
            i++;
        }
        res += map.get(ss[i]);
        return res;
    }
}
