package leetcode;

/**
 * @author Kuma
 * @date 2021年2月19日
 * 1004.最大连续1的个数 III
 */
public class Lc1004 {
    public static int longestOnes(int[] A, int K) {
        int left = 0;
        int right = 0;
        int len = 0;
        while (right < A.length){
            if (A[right] == 0){
                K--;
            }
            while (K < 0){
                if (A[left] == 0){
                    K++;
                }
                left++;
            }
            len = Math.max(len,right - left + 1);
            right++;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        longestOnes(a,k);
    }
}
