package leetcode;

import java.util.LinkedList;

/**
 * @author Kuma
 * @date 2021年3月14日
 * 1415. 长度为 n 的开心字符串中字典序第 k 小的字符串
 */
public class Lc1415 {
    LinkedList<String> res = new LinkedList<>();
    StringBuilder tmp = new StringBuilder();

    public String getHappyString(int n, int k) {
        trackBack(-1, n, k);
        return res.size() >= k ? res.get(k - 1) : "";
    }

    /**
     * 回溯枚举
     * @param i 当前字符
     * @param n 所需长度
     * @param k 所需长度
     */
    public void trackBack(int i, int n, int k){
        if (res.size() == k){
            return;
        }
        if (tmp.length() == n){
            System.out.println(tmp.toString());
            res.add(tmp.toString());
            return;
        }
        for (int j = 0; j < 3; j++) {
            if (j != i){
                tmp.append(Character.toChars('a' + j));
                trackBack(j, n, k);
                tmp.deleteCharAt(tmp.length() - 1);
            }
        }
    }
}
