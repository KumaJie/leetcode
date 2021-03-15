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
//        四个方向
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int curDir = 0;
//        四个边界
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;
        int top = 0;
        int sum = matrix.length * matrix[0].length;
        int i = 0;
        int j = 0;
        while (res.size() < sum){
            res.add(matrix[i][j]);
            if (curDir == 0 && j == right){
                curDir++;
                top++;
            }
            if (curDir == 1 && i == bottom){
                curDir++;
                right--;
            }
            if (curDir == 2 && j == left){
                curDir++;
                bottom--;
            }
            if (curDir == 3 && i == top){
                curDir++;
                left++;
            }
            curDir %= 4;
            i += dir[curDir][0];
            j += dir[curDir][1];
        }
        return res;
    }
}
