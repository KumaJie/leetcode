package leetcode;

/**
 * @author Kuma
 * @date 2021年2月5日
 * 70.爬楼梯
 */
public class Lc70 {
    public int climbStairs(int n) {
        int[] bp = new int[n + 1];
        bp[0] = 1;
        bp[1] = 1;
        for (int i = 2; i < bp.length; i++) {
            bp[i] = bp[i - 1] + bp[i - 2];
        }
        return bp[n];
    }
}
