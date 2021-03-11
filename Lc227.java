package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Kuma
 * @date 2021年3月11日
 * 227. 基本计算器 II
 */
public class Lc227 {
    public static int calculate(String s) {
//        数值和算符栈
        Stack<Integer> numSt = new Stack<>();
        Stack<Character> opTt = new Stack<>();
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        s = s.replaceAll(" ","");
        char[] ar = s.toCharArray();
        int i = 0;
        while (i < ar.length){
            int num = 0;
            while (i < ar.length && Character.isDigit(ar[i])){
                num = num * 10 + ar[i++] - '0';
            }
            numSt.push(num);
            if (i < ar.length && ar[i] != ' '){
                while (!opTt.isEmpty() && map.get(ar[i]) <= map.get(opTt.peek())) {
                    int a = numSt.pop();
                    int b = numSt.pop();
                    int flag = map.get(opTt.peek());
                    if (flag == 1) {
                        numSt.push(opTt.pop() == '+' ? b + a : b - a);
                    } else {
                        numSt.push(opTt.pop() == '*' ? b * a : b / a);
                    }
                }
                opTt.push(ar[i]);
            }
            i++;
        }
        while (!opTt.isEmpty()) {
            int a = numSt.pop();
            int b = numSt.pop();
            int flag = map.get(opTt.peek());
            if (flag == 1) {
                numSt.push(opTt.pop() == '+' ? b + a : b - a);
            } else {
                numSt.push(opTt.pop() == '*' ? b * a : b / a);
            }
        }
        return numSt.pop();
    }

    public static void main(String[] args) {
        String s = " 3+5 / 2";
        System.out.println(calculate(s));
    }
}
