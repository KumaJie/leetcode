package leetcode;

/**
 * @author Kuma
 * @date 2021年2月8日
 * 1025.除数博弈
 */
public class Lc1025 {
    public boolean divisorGame(int N) {
        boolean[] bp = new boolean[N + 5];
        bp[1] = false;
        bp[2] = true;
        for (int i = 3; i <= bp.length; i++) {
            for (int j = 1; j < i; j++) {
                if(i % j == 0 && !bp[i - j]){
                    bp[i] = true;
                    break;
                }
            }
        }
        return bp[N];
    }
}