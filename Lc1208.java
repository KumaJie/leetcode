package leetcode;

/**
 * @author Kuma
 * @date 2021年2月5日
 * 1208. 尽可能使字符串相等
 */
public class Lc1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] dif = new int[len];
        for (int i = 0; i < len; i++) {
            dif[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int max = 0;
        int left = 0;
        int right = 0;
        int cost = 0;
        while (right < len){
            cost += dif[right];
            while (cost > maxCost){
                cost -= dif[left++];
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
