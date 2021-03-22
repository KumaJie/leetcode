package leetcode;

/**
 * @author Kuma
 * @date 2021年3月22日
 * 191. 位1的个数
 */
public class Lc191 {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
