package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 可被5整除的二进制前缀
 *
 * @author Kuma
 */
public class Lc1018 {
    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> result = new ArrayList<>();
        int n = 0;
        for (int j : A) {
//            左移运算累加，只保留余数
            n = ((n << 1) + j) % 5;
            result.add(n == 0);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {0, 1, 1};
        prefixesDivBy5(A);
    }
}
