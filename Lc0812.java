package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kuma
 * @date 2021年3月11日
 * 面试题 08.12. n皇后
 */
public class Lc0812 {
/**
 * 记录每行皇后的列
  */
    int[] colQ;
    int n;
    List<List<String>> res = new ArrayList<>();
    List<String> tmp = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        colQ = new int[n];
        Arrays.fill(colQ, -1);
        this.n = n;
        solve(0);
        return res;
    }

    public void solve(int i){
        if (i == n){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (safePos(i,j)){
                addPath(j);
                colQ[i] = j;
                solve(i + 1);
                colQ[i] = -1;
                tmp.remove(tmp.size() - 1);
            }
        }

    }

    public void addPath(int i){
        StringBuilder line = new StringBuilder();
        for (int j = 0; j < n; j++) {
            if (j != i){
                line.append('.');
            }else {
                line.append('Q');
            }
        }
        tmp.add(line.toString());
    }

    /**
     * 判断是否可以安放棋子
     * @param row 待定行
     * @param col 待定列
     * @return 当前位置是否可以放置
     */
    public boolean safePos(int row, int col){
        for (int i = 0; i < colQ.length; i++) {
            int j = colQ[i];
            if (j == -1){
                continue;
            }
            if (j == col){
                return false;
            }
            if (i + j == row + col){
                return false;
            }
            if (i - j == row - col){
                return false;
            }
        }
        return true;
    }
}
