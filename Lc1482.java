package leetcode;

/**
 * @author Kuma
 * @date 2021年5月16日
 * 1482.制作 m 束花所需的最少天数
 */
public class Lc1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : bloomDay){
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        int l = min;
        int r = max;
        while (l < r){
            int mid = l + r >> 1;
            if (check(bloomDay, m, k, mid)){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return check(bloomDay, m, k, r) ? r : -1;
    }

    boolean check(int[] bloomDay, int m, int k, int mid){
        int num = 0;
        for (int i : bloomDay){
            if (i <= mid){
                num++;
            }else if (num > 0){
                num = 0;
            }
            if (num == k){
                m--;
                num = 0;
            }
        }
        return m <= 0;
    }
}
