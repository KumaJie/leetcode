package leetcode;
import java.util.*;
public class Main{

    static class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            Map<Integer,Integer> map = new HashMap();
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < edges.length; i++) {
                Integer value = map.get(edges[i][0]);
                Integer to = map.get(edges[i][1]) == null?edges[i][1]:map.get(edges[i][1]);
                if(map.get(edges[i][0]) != null && map.get(edges[i][1]) != null && value.equals(to)){
                    result.add(edges[i][0]);
                    result.add(edges[i][1]);
                }
                if(value != null){
                    for (Map.Entry<Integer,Integer> e:map.entrySet()) {
                        if (e.getValue().equals(value)) {
                            map.put(e.getKey(), to);
                        }
                    }
                }else {
                    map.put(edges[i][0],to);
                }
                if(map.get(edges[i][1]) == null){
                    map.put(edges[i][1],edges[i][1]);
                }
            }
            int[] s = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                s[i] = result.get(i);
            }
            return s;
        }
    }

    public static void main(String args[]){
        int[][] a = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        new Solution().findRedundantConnection(a);
    }
}
