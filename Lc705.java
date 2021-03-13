package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Kuma
 * @date 2021年3月13日
 * 705. 设计哈希集合
 */
public class Lc705 {
    public static void main(String[] args) {
        MyHashSet h = new MyHashSet();
        h.add(1);
        h.add(2);
        h.contains(1);
        h.remove(1);
    }
}
class MyHashSet {
    ArrayList<ArrayList<Integer>> hash;
    int max = 10;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hash = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            hash.add(new ArrayList<>());
        }
    }

    public void add(int key) {
        int hashCode = key % max;
        if (!hash.get(hashCode).contains(key)){
            hash.get(hashCode).add(key);
        }
    }

    public void remove(int key) {
        int hashCode = key % max;
        if (hash.get(hashCode).contains(key)){
            hash.get(hashCode).remove((Integer)key);
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return hash.get(key % max).contains(key);

    }
}
