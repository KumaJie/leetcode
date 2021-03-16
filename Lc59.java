package leetcode;

/**
 * @author Kuma
 * @date 2021年3月16日
 * 59. 螺旋矩阵 II
 */
public class Lc59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int right = n - 1;
        int left = 0;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int curDir = 0;
        int i = 0;
        int j = 0;
        int curNum = 1;
        while (curNum <= n * n){
            res[i][j] = curNum++;
            if (j == right && curDir == 0){
                curDir++;
                top++;
            }
            if (i == bottom && curDir == 1){
                curDir++;
                right--;
            }
            if (j == left && curDir == 2){
                curDir++;
                bottom--;
            }
            if (i == top && curDir == 3){
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

