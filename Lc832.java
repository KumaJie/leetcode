package leetcode;

/**
 * @author Kuma
 * @date 2021年2月24日
 * 832.翻转图像
 */
public class Lc832 {
    public int[][] flipAndInvertImage(int[][] A) {
//        1.额外空间解法
//        int[][] arr = new int[A.length][A[0].length];
//        for(int i = 0;i < A.length;i++){
//            for(int k = A[i].length - 1;k >= 0;k--){
//                arr[i][A[i].length - 1 - k] = A[i][k] == 1 ? 0 : 1;
//            }
//        }
//        return arr;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < (A[0].length + 1) / 2; j++) {
                int tmp = A[i][j];
                A[i][j] = 1 - A[i][A[0].length - 1 - j];
                A[i][A[0].length - 1 - j] = 1 - tmp;
            }
        }
        return A;
    }
}
