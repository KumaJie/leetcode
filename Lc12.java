package leetcode;

import java.util.TreeMap;

/**
 * @author Kuma
 * @date 2021年5月16日
 * 12.整数转罗马数字
 */
public class Lc12 {
    public String intToRoman(int num) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        StringBuilder res = new StringBuilder();
        int max = 0;
        while (num > 0){
            max = map.floorKey(num);
            res.append(map.get(max));
            num -= max;
        }
        return res.toString();
    }
}
