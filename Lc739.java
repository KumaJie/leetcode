package leetcode;

import java.util.Stack;

/**
 * @author Kuma
 * @date 2021年3月6日
 * 739. 每日温度
 */
public class Lc739 {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.empty() && T[st.peek()] < T[i]){
                int c = st.pop();
                res[c] = i - c;
            }
            st.push(i);
        }
        return res;
    }
}
