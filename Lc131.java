package leetcode;

import java.util.*;

/**
 * @author Kuma
 * @date 2021年3月8日
 * 131. 分割回文串
 */
public class Lc131 {
    int n;
    boolean[][] bp;
    List<List<String>> res = new ArrayList<>();
    List<String> tmp = new ArrayList<>();

    public List<List<String>> partition(String s) {
        n = s.length();
        bp = new boolean[n][n];
        for (boolean[] i : bp){
            Arrays.fill(i, true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                bp[i][j] = bp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        dfs(s, 0);
        return res;
    }

    public void dfs(String s, int i){
        if (i == n){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int j = i; j < n; j++) {
            if (bp[i][j]){
                tmp.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
