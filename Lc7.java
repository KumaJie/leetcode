package leetcode;

/**
 * @author Kuma
 * @date 2021年5月3日
 * 7.整数反转
 */
public class Lc7 {
    public int reverse(int x) {
        long ans = 0;
        while (x != 0){
            int cur = x % 10;
            ans = ans * 10 + cur;
            x /= 10;
        }
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE){
            return 0;
        }
        return (int)ans;
    }
}
