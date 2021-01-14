package leetcode;

/**
 * @author Kuma
 * @date 2021年1月14日
 * 有序矩阵中第K小的元素
 */
public class Lc378 {
    public static int kthSmallest(int[][] matrix, int k) {
        int length = matrix.length;
        int left = matrix[0][0];
        int right = matrix[length - 1][length - 1];
        while (left < right){
            int mid = (left + right) / 2;
            int sum = check(matrix,mid);
            if(sum < k){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }
    public static int check(int[][] martrix, int mid){
//        小于mid的元素总数
        int sum = 0;
        int j = 0;
        for (int i = martrix.length - 1; i >= 0; i--) {
            while (j < martrix[0].length){
                if (martrix[i][j] <= mid){
                    sum += i+1;
                    j++;
                }else{
                    break;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] a = {
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}};
        kthSmallest(a,8);
    }
}
