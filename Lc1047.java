package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Kuma
 * @date 2021年3月9日
 * 1047.删除字符串中的所有相邻重复项
 */
public class Lc1047 {
    public String removeDuplicates(String S) {
        Stack<Character> st = new Stack<>();
        char[] s = S.toCharArray();
        for (char i : s){
            if (st.isEmpty() || st.peek() != i){
                st.push(i);
            }else if (st.peek() == i){
                st.pop();
            }
        }
        StringBuilder res = new StringBuilder();
        for (char c : st){
            res.append(c);
        }
        return res.reverse().toString();
    }
}
