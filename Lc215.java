package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Kuma
 * @date 2021年2月15日
 * 215. 数组中的第K个最大元素
 */
public class Lc215 {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> qu = new PriorityQueue<>();
        for(int i : nums){
            qu.offer(i);
            if(qu.size() > k){
                qu.poll();
            }
        }
        return qu.peek();
    }
}
