package leetcode;

/**
 * @author Kuma
 * @date 2021年3月2日
 * 304. 二维区域和检索 - 矩阵不可变
 */
public class Lc304 {
}
class NumMatrix {
    int[][] dp;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        if (row == 0){
            return;
        }
        int col = matrix[0].length;
        dp = new int[row + 1][col + 1];
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                dp[i][j] = matrix[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
}
