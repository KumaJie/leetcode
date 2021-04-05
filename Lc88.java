package leetcode;

import java.util.Arrays;

/**
 * @author Kuma
 * @date 2021年4月5日
 * 88.合并两个有序数组
 */
public class Lc88 {
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int sum = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0){
            nums1[sum--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n >= 0){
            nums1[sum--] = nums2[n--];
        }
    }
}
