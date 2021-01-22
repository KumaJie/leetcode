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
        String k = K+"";
        int i = A.length - 1;
        int j = k.length() - 1;
        boolean flag = false;
        while (i >= 0 && j >= 0){
            int add = A[i--] + (k.charAt(j--)-'0');
            if (flag){
                add++;
            }
            if(add >= 10){
                flag = true;
                add -= 10;
            }else {
                flag = false;
            }
            result.add(add);
        }
        while (i >= 0){
            int add = A[i--];
            if (flag){
                add++;
            }
            if(add >= 10){
                flag = true;
                add -= 10;
            }else {
                flag = false;
            }
            result.add(add);
        }
        while (j >= 0){
            int add = k.charAt(j--)-'0';
            if (flag){
                add++;
            }
            if(add >= 10){
                flag = true;
                add -= 10;
            }else {
                flag = false;
            }
            result.add(add);
        }
        if(flag){
            result.add(1);
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
