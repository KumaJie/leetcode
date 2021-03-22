package leetcode;

import java.util.Stack;

/**
 * @author Kuma
 * @date 2021年3月22日
 * 150.逆波兰表达式求值
 */
public class Lc150 {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String token : tokens){
            char c = token.charAt(token.length() - 1);
            if (Character.isDigit(c)){
                st.push(Integer.parseInt(token));
            }else {
                int b = st.pop();
                int a = st.pop();
                if (c == '+'){
                    st.push(a + b);
                }else if (c == '-'){
                    st.push(a - b);
                }else if (c == '*'){
                    st.push(a * b);
                }else {
                    st.push(a / b);
                }
            }
        }
        System.out.println(st.peek());
        return st.pop();
    }

    public static void main(String[] args) {
        String[] t = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        evalRPN(t);
    }
}
