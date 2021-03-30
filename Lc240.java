package leetcode;

/**
 * @author Kuma
 * @date 2021年3月30日
 * 240. 搜索二维矩阵 II
 */
public class Lc240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0){
            if (matrix[i][j] < target){
                i++;
            }else if (matrix[i][j] > target){
                j--;
            }else {
                return true;
            }
        }
        return false;
    }
}
