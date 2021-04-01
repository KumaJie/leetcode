package leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Kuma
 * @date 2021年4月1日
 * 1006. 笨阶乘
 */
public class Lc1006 {
    public static int clumsy(int N) {
        Stack<Integer> num = new Stack<>();
        Stack<Integer> op = new Stack<>();
        int[] weight = {2,2,1,1};
        int cur = 0;
        for (int i = N;i > 0;i--){
            num.push(i);
            if (i != 1){
                while (!op.isEmpty() && weight[op.peek()] >= weight[cur]){
                    int b = num.pop();
                    int a = num.pop();
                    int curOp = op.pop() % 4;
                    if (curOp == 0){
                        num.push(a * b);
                    }else if (curOp == 1){
                        num.push(a / b);
                    }else if (curOp == 2){
                        num.push(a + b);
                    }else {
                        num.push(a - b);
                    }
                }
                op.push(cur);
                cur = (cur + 1) % 4;
            }
        }
        while (!op.isEmpty()){
            int b = num.pop();
            int a = num.pop();
            int curOp = op.pop() % 4;
            if (curOp == 0){
                num.push(a * b);
            }else if (curOp == 1){
                num.push(a / b);
            }else if (curOp == 2){
                num.push(a + b);
            }else {
                num.push(a - b);
            }
        }
        return num.pop();
    }

    public static void main(String[] args) {
        clumsy(4);
    }
}
