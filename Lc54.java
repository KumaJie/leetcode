package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kuma
 * @date 2021年3月15日
 * 54. 螺旋矩阵
 */
public class Lc54 {
    public static void main(String[] args) {
        Solution s= new Solution();
        int[][] arr= {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        s.spiralOrder(arr);
    }
}
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int sum = matrix.length * matrix[0].length;
        int i = 0;
        int j = 0;
        res.add(matrix[i][j]);
        matrix[i][j] = 101;
        while (res.size() < sum){
            while (j + 1 < matrix[0].length && matrix[i][j + 1] != 101){
                res.add(matrix[i][j + 1]);
                matrix[i][j++] = 101;
            }
            while (i + 1 < matrix.length && matrix[i + 1][j] != 101) {
                res.add(matrix[i + 1][j]);
                matrix[i++][j] = 101;
            }
            while (j - 1 >= 0 && matrix[i][j - 1] != 101){
                res.add(matrix[i][j - 1]);
                matrix[i][j--] = 101;
            }
            while (i - 1 >= 0 && matrix[i - 1][j] != 101) {
                res.add(matrix[i - 1][j]);
                matrix[i--][j] = 101;
            }
        }
        return res;
    }
}
