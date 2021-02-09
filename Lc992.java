package leetcode;

/**
 * @author Kuma
 * @date 2021年2月9日
 * 992. K 个不同整数的子数组
 */
public class Lc992 {
    public static int subarraysWithKDistinct(int[] A, int K) {
        return subarrayMostK(A,K) - subarrayMostK(A,K - 1);
    }

    public static int subarrayMostK(int[] A, int K){
        int n = A.length;
        int left = 0;
        int right = 0;
//        不同数字
        int[] freq = new int[n + 1];
        int distinct = 0;
        int res = 0;
        while (right < n){
            if(freq[A[right]] == 0){
                distinct++;
            }
            freq[A[right]]++;
            right++;
            while (distinct > K){
                freq[A[left]]--;
                if(freq[A[left]] == 0){
                    distinct--;
                }
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {2,1,2,1,2};
        int k = 2;
        subarraysWithKDistinct(a,k);
    }
}
