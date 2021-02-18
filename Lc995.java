package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kuma
 * @date 2021年2月18日
 * 995. K连续位的最小翻转次数
 */
public class Lc995 {
    public int minKBitFlips(int[] A, int K) {
        Queue<Integer> qu = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (qu.size() > 0 && i == qu.peek() + K){
                qu.poll();
            }
            if (qu.size() % 2 == A[i]){
                if (i + K > A.length){
                    return -1;
                }
                res++;
                qu.offer(i);
            }
        }
        return res;
    }
}
