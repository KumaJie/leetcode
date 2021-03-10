package leetcode;

import java.util.Stack;

/**
 * @author Kuma
 * @date 2021年3月10日
 * 224. 基本计算器
 */
public class Lc224 {
    public static int calculate(String s) {
//        数值栈和符号栈
        Stack<Integer> numSt = new Stack<>();
        Stack<Character> chSt = new Stack<>();
//        防止第一个数字为负数
        numSt.push(0);
        char[] ar = s.toCharArray();
        int i = 0;
        int tmp;
        while (i < ar.length){
            StringBuilder t = new StringBuilder();
            while (i < ar.length && Character.isDigit(ar[i])){
                t.append(ar[i]);
                i++;
            }
            if (t.length() != 0){
                numSt.push(Integer.parseInt(t.toString()));
            }
            if (i < ar.length && ar[i] != ' '){
                if (chSt.isEmpty() || ar[i] == '('){
                    chSt.push(ar[i]);
                } else {
                    while (!chSt.isEmpty() && chSt.peek() != '('){
                        int a = numSt.pop();
                        int b = numSt.pop();
                        boolean flag = chSt.pop() == '+';
                        if (flag){
                            tmp = b + a;
                        }else {
                            tmp = b - a;
                        }
                        numSt.push(tmp);
                    }
                    if (ar[i] == ')'){
                        chSt.pop();
                    }else {
                        chSt.push(ar[i]);
                    }
                }
            }
            i++;
        }
        while (!chSt.isEmpty()){
            int a = numSt.pop();
            int b = numSt.pop();
            boolean flag = chSt.pop() == '+';
            if (flag){
                tmp = b + a;
            }else {
                tmp = b - a;
            }
            numSt.push(tmp);
        }
        return numSt.pop();
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        int a = calculate(s);
        System.out.println(a);
    }
}
