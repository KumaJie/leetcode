package leetcode;

/**
 * @author Kuma
 * @date 2021年3月2日
 * 896. 单调数列
 */
public class Lc896 {
    public boolean isMonotonic(int[] A) {
//        只有单调才为true
        boolean inc = true;
        boolean dec = true;
        for (int i = 1; i < A.length; i++) {
            inc = inc ? A[i] >= A[i - 1] : inc;
            dec =  dec ? A[i] <= A[i - 1] : dec;
        }
        return inc || dec;

    }
}
