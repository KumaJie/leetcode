package leetcode;

import java.util.*;

/**
 * @author Kuma
 * @date 2021年5月3日
 * 554.砖墙
 */
public class Lc554 {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> map = new HashMap<>();
//        查找相交最多的点
        for (List<Integer> l : wall){
            int sum = 0;
            for (int i = 0; i < l.size() - 1; i++) {
                sum += l.get(i);
                map.put(sum,map.getOrDefault(sum,0) + 1);
            }
        }
        int max = 0;
        for (Map.Entry<Integer,Integer> e : map.entrySet()){
            if (e.getValue() > max){
                max = e.getValue();
            }
        }
        return wall.size() - max;
    }
}
