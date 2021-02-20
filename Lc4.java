package leetcode;

import java.util.PriorityQueue;

/**
 * @author Kuma
 * @date 2021年2月20日
 * 4. 寻找两个正序数组的中位数
 */
public class Lc4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> qu = new PriorityQueue<>();
        int size = nums1.length + nums2.length;
        int k = size / 2 + 1;
        add(qu,k,nums1);
        add(qu,k,nums2);
        if (size % 2 == 0){
            return (double)((qu.poll() + qu.poll())) / 2;
        }else{
            return (double)qu.poll();
        }

    }
    public void add(PriorityQueue<Integer> qu, int size, int[] arr){
        for(int i : arr){
            qu.offer(i);
            if (qu.size() > size){
                qu.poll();
            }
        }
    }
}
