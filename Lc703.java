package leetcode;

import java.util.*;

/**
 * @author Kuma
 * @date 2021年2月15日
 * 703.数据流中的第 K 大元素
 */
public class Lc703 {
    public static void main(String[] args) {
        int k = 3;
        int[] a = {4,5,8,2};
        KthLargest b = new KthLargest(k,a);
        b.add(3);
        b.add(5);
        b.add(10);
        b.add(9);
        b.add(4);


    }
}
class KthLargest {
    int k;
    Queue<Integer> qu = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        qu.offer(val);
        if(qu.size() > k){
            qu.poll();
        }
        return qu.peek();
    }
}
