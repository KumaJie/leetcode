package leetcode;

/**
 * @author Kuma
 * @date 2021年2月23日
 * 5. 最长回文子串
 */
public class Lc5 {
    public String longestPalindrome(String s) {
        boolean[][] bp = new boolean[s.length()][s.length()];
        String res = "";
//        字串长度
        for (int i = 0; i < s.length(); i++) {
//            起始位置
            for (int j = 0; i + j < s.length(); j++) {
                int k = i + j;
                if (i == 0){
                    bp[j][k] = true;
                }else if (i == 1 && s.charAt(j) == s.charAt(k)){
                    bp[j][k] = true;
                }else {
                    bp[j][k] = bp[j + 1][k - 1] && s.charAt(j) == s.charAt(k);
                }
                if (bp[j][k] && res.length() < i + 1){
                    res = s.substring(j, k + 1);
                }
            }
        }
        return res;
    }
}
