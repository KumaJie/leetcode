package leetcode;

import java.util.Arrays;

/**
 * @author Kuma
 * @date 2021年6月1日
 * 1744.你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 */
public class Lc1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = queries.length;
        int m = candiesCount.length;
        int[] prefix = new int[m + 1];
        for (int i = 1; i < m + 1; i++) {
            prefix[i] = prefix[i - 1] + candiesCount[i - 1];
        }
        boolean[] res = new boolean[n];
        int type;
        int day;
        int cap;
        long earliest;
        long latest;
        for (int i = 0; i < n; i++) {
            type = queries[i][0];
//            从第0天开始吃，所以多一天
            day = queries[i][1] + 1;
            cap = queries[i][2];
            earliest = prefix[type] / cap + 1;
            latest = prefix[type + 1];
            res[i] = earliest <= day && latest >= day;
        }
        return res;
    }
}
