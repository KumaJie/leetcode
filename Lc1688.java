package leetcode;

/**
 * @author Kuma
 * @date 2021年3月11日
 * 1688. 比赛中的配对次数
 */
public class Lc1688 {
    public int numberOfMatches(int n) {
        if (n == 1){
            return 0;
        }
        int t;
        if (n % 2 == 0){
            t = numberOfMatches(n / 2);
        }else {
            t = numberOfMatches(n / 2 + 1);
        }
        return n / 2 + t;
    }

}
