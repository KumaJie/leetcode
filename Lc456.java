package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Kuma
 * @date 2021年3月24日
 * 456.132 模式
 */
public class Lc456 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        Arrays.fill(min,Integer.MAX_VALUE);
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], nums[i - 1]);
        }
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i > 0; i--) {
            int minTmp = Integer.MIN_VALUE;
            while (!st.isEmpty() && st.peek() < nums[i]){
                minTmp = st.pop();
            }
            if (minTmp > min[i]){
                return true;
            }
            st.push(nums[i]);
        }
        return false;
    }
}
