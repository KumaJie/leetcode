package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Kuma
 * @date 2021年3月11日
 * 1286. 字母组合迭代器
 */
public class Lc1286 {
}
class CombinationIterator {
    Queue<String> res = new LinkedList<>();
    StringBuilder tmp = new StringBuilder();
    char[] ch;
    int n;

    public CombinationIterator(String characters, int combinationLength) {
        ch = characters.toCharArray();
        n = combinationLength;
        search(0);
    }

    public void search(int i){
        if (tmp.length() == n){
            res.offer(tmp.toString());
            return;
        }
        for (int j = i ; j < ch.length; j++) {
            tmp.append(ch[j]);
            if (!res.contains(tmp.toString())) {
                search(j + 1);
            }
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }

    public String next() {
        return res.poll();
    }

    public boolean hasNext() {
        return !res.isEmpty();
    }
}
