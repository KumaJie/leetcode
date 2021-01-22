package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Kuma
 * @date 2021年1月22日
 * 数组形式的整数加法
 */
public class Lc989 {
    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        int i = A.length - 1;
//        进位
        int carry = 0;
        while (i >= 0 || K != 0){
//            计算低位
            int a = i >= 0 ? A[i] : 0;
            int b = K % 10;
            int add = a + b + carry;
            carry = add / 10;
            i--;
            K /= 10;
            result.add(add % 10);
        }
        if(carry != 0){
            result.add(carry);
        }
        // 翻转
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        int[] b = {9,9,9,9,9,9,9,9,9,9};
        int k = 1;
        addToArrayForm(b,k);
    }
}
