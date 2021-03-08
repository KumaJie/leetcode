package leetcode;

import java.util.*;

/**
 * @author Kuma
 * @date 2021年3月8日
 * 131. 分割回文串
 */
public class Lc131 {
    int n;
    int[][] bp;
    List<List<String>> res = new ArrayList<>();
    List<String> tmp = new ArrayList<>();

    public List<List<String>> partition(String s) {
        n = s.length();
        bp = new int[n][n];
        dfs(s, 0);
        return res;
    }

    public void dfs(String s, int i){
        if (i == n){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int j = i; j < n; j++) {
            if (isPalindrome(s, i ,j) > 0){
                tmp.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

//    记忆化
    public int isPalindrome(String s, int i, int j){
        if (bp[i][j] != 0){
            return bp[i][j];
        }
        if (i >= j){
            bp[i][j] = 1;
        }else if (s.charAt(i) == s.charAt(j)){
            return isPalindrome(s, i + 1, j - 1);
        }else {
            bp[i][j] = -1;
        }
        return bp[i][j];
    }


}
