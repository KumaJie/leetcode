package leetcode;

/**
 * @author Kuma
 * @date 2021年2月23日
 * 5. 最长回文子串
 */
public class Lc5 {
    int[][] bp;
    public String longestPalindrome(String s) {
        int n = s.length();
        bp = new int[n][n];
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (m(s, i, j) > 0 && res.length() < j - i + 1){
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
//    记忆化
    public int m(String s, int i, int j){
        if (bp[i][j] != 0){
            return bp[i][j];
        }
        if (i >= j){
            bp[i][j] = 1;
        }else if (s.charAt(i) == s.charAt(j)){
            return m(s, i + 1, j - 1);
        }else {
            bp[i][j] = -1;
        }
        return bp[i][j];
    }

}
