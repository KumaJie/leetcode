package leetcode;

/**
 * @author Kuma
 * @date 2021年2月17日
 * 566.重塑矩阵
 */
public class Lc566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int column = nums[0].length;
        if(row * column != r * c){
            return nums;
        }
        int[][] res = new int[r][c];
        int a = 0;
        int b = 0;
        for (int[] i : res){
            for(int j : i){
                res[a][b++] = j;
                if(b >= c){
                    a++;
                    b = 0;
                }
            }
        }
        return res;
    }
}
