package leetcode;

/**
 * @author Kuma
 * @date 2021年4月30日
 * 29.两数相除
 */
public class Lc29 {
    public int divide(int dividend, int divisor) {
        long x = dividend, y = divisor;
        boolean op = x >= 0 && y >= 0 || x <= 0 && y <= 0;
        x = Math.abs(x);
        y = Math.abs(y);
        long l = 0, r = x;
        while (l < r){
            long mid = l + r + 1 >> 1;
            if (mul(mid, y) <= x){
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        l = op ? l : -l;
        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)l;
    }

    /**
     * 计算a * b
     */
    public static long mul(long a, long b){
        long ans = 0;
        while (b > 0){
            if ((b & 1) == 1){
                ans += a;
            }
            b >>= 1;
            a += a;
        }
        return ans;
    }

}
