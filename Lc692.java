package leetcode;

import java.util.*;

/**
 * @author Kuma
 * @date 2021年5月25日
 * 692.前K个高频单词
 */
public class Lc692 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : words){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            int v1 = map.get(o1);
            int v2 = map.get(o2);
            if (v1 == v2){
                return o2.compareTo(o1);
            }else {
                return v1 - v2;
            }
        });
        for (String str : words){
            if (!pq.contains(str)){
                pq.offer(str);
                if (pq.size() > k){
                    pq.poll();
                }
            }
        }
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()){
            res.add(pq.poll());
        }
        res.sort((o1, o2) -> {
            int v1 = map.get(o1);
            int v2 = map.get(o2);
            if (v1 == v2){
                return o1.charAt(0) - o2.charAt(0);
            }else {
                return v2 - v1;
            }
        });
        return res;
    }

    public static void main(String[] args) {
        String str1 = "aa";
        String str2 = "a";
        System.out.println(str1.compareTo(str2));
    }
}
