package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Kuma
 * @date 2021年3月6日
 * 503.下一个更大元素 II
 */
public class Lc503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!st.empty() && nums[st.peek()] < nums[i % n]){
                res[st.pop()] = nums[i % n];
            }
            st.push(i % n);
        }
        return res;
    }
}
