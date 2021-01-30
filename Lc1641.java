package leetcode;

/**
 * @author Kuma
 * @date 2021年1月30日
 * 1641. 统计字典序元音字符串的数目
 */
public class Lc1641 {
    public int countVowelStrings(int n) {
        int[][] bp = new int[n + 1][6];
        for (int i = 1; i < bp.length; i++) {
            for (int j = 1; j < bp[0].length; j++) {
                if (i == 1 && j == 1){
                    bp[1][1] = 1;
                    continue;
                }
                bp[i][j] = bp[i][j - 1] + bp[i - 1][j];
            }
        }
        int res = 0;
        for (int i = 1; i < bp[0].length; i++) {
            res += bp[n][i];
        }
        return res;
    }
}
