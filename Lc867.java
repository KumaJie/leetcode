package leetcode;

/**
 * @author Kuma
 * @date 2021年2月26日
 * 867.转置矩阵
 */
public class Lc867 {
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                res[i][j] = matrix[j][i];
            }
        }
        return res;
    }
}
