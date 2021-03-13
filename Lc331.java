package leetcode;

import java.util.Stack;

/**
 * @author Kuma
 * @date 2021年3月13日
 * 331. 验证二叉树的前序序列化
 */
public class Lc331 {
    public boolean isValidSerialization(String preorder) {
        Stack<String> st = new Stack<>();
        String[] pre = preorder.split(",");
        int n = pre.length;
        int i = 0;
        while (i < n){
            String str = pre[i];
            if (!st.isEmpty() && "#".equals(str) && "#".equals(st.peek())) {
                while (!st.isEmpty() && "#".equals(st.peek())) {
                    st.pop();
                    if (st.isEmpty()) {
                        return false;
                    }
                    st.pop();
                }
            }
            st.push(str);
            i++;
        }
        return st.size() == 1 && "#".equals(st.peek());
    }
}
