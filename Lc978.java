package leetcode;

import java.util.Arrays;

/**
 * @author Kuma
 * @date 2021年1月30日
 * 978.最长湍流子数组
 */
public class Lc978 {
    public static int maxTurbulenceSize(int[] arr) {
        int[] bp = new int[arr.length];
        Arrays.fill(bp,1);
        boolean flag = false;
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            if (i == 1){
                if(arr[i] != arr[i - 1]){
                    bp[i] += bp[i - 1];
                    flag = arr[i] > arr[i - 1];
                }
                max = Math.max(max,bp[i]);
                continue;
            }
            if(arr[i] > arr[i - 1] && !flag){
                bp[i] += bp[i - 1];
                flag = true;
            }else if(arr[i] < arr[i - 1] && flag){
                bp[i] += bp[i - 1];
                flag = false;
            }else if (arr[i] != arr[i - 1]){
                bp[i]++;
            }
            max = Math.max(max,bp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {9,4,2,10,7,8,8,1,9};
        maxTurbulenceSize(a);
    }
}
