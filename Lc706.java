package leetcode;

import java.util.ArrayList;

/**
 * @author Kuma
 * @date 2021年3月14日
 * 706. 设计哈希映射
 */
public class Lc706 {
}
class MyHashMap {
    ArrayList<ArrayList<int[]>> hashmap;
    int max  = 50;
    /** Initialize your data structure here. */
    public MyHashMap() {
        hashmap = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            hashmap.add(new ArrayList<>());
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int code = key % max;
        for (int[] i : hashmap.get(code)){
            if (i[0] == key){
                i[1] = value;
                return;
            }
        }
        hashmap.get(code).add(new int[]{key,value});
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int code = key % max;
        for (int[] i : hashmap.get(code)){
            if (i[0] == key){
                return i[1];
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int code = key % max;
        for (int[] i : hashmap.get(code)){
            if (i[0] == key){
                hashmap.get(code).remove(i);
                break;
            }
        }
    }
}
