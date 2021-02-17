package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Kuma
 * @date 2021年2月17日
 * 119. 杨辉三角 II
 */
public class Lc119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new LinkedList<>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            res.add(0);
            for (int j = i; j > 0; j--) {
                res.set(j,res.get(j) + res.get(j - 1));
            }
            System.out.println(res);
        }
        return res;
    }
}
