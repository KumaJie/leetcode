package leetcode;

/**
 * @author Kuma
 * @date 2021年4月29日
 * 1011.在 D天内送达包裹的能力
 */
public class Lc1011 {
    /**
     * 采用二分思想，将承重量范围进行确定，
     * ans为最低运力，小于ans一定不满足条件，大于ans满足条件
     * @param weights 包裹重量
     * @param D 运送天数
     * @return ans
     */
    public int shipWithinDays(int[] weights, int D) {
        int max = 0, sum = 0;
        for (int i : weights){
            sum += i;
            max = Math.max(max, i);
        }
        int l = max, r = sum;
        while(l < r){
            int mid = l + r >> 1;
            if (check(weights, D, mid)){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return r;
    }

    public boolean check(int[] weights, int D, int carriage){
        int day = 0;
        int i = 1;
        int sum  = weights[0];
        while (i < weights.length){
            while (i < weights.length && sum + weights[i] <= carriage){
                sum += weights[i];
                i++;
            }
            day++;
            sum = 0;
        }
        return day <= D;
    }
}
