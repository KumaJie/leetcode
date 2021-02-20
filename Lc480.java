package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Kuma
 * @date 2021年2月20日
 * 480.滑动窗口中位数
 */
public class Lc480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Queue<Integer> qu = new PriorityQueue<>();
        List<Double> mid = new LinkedList<>();
        for (int i = 0; i < nums.length - k + 1; i++) {
            if (i == 0){
                for (int j = 0;j < k;j++){
                    qu.offer(nums[j]);
                }
            }else {
                qu.remove(nums[i - 1]);
                qu.offer(nums[i + k - 1]);
            }
            int count = 0;
            if (k % 2 == 0){
                double res = 0;
                for (Integer j : qu){
                    if (count == k / 2 || count == k / 2 +1){
                        res += j;
                    }
                    count++;
                }
                mid.add(res / 2);
            }else {
                for (Integer j : qu){
                    if (count == k / 2){
                        mid.add((double) j);
                    }
                    count++;
                }
            }
        }
    }
}
