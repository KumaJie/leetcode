package leetcode;

import java.util.*;

/**
 * @author Kuma
 * @date 2021年2月20日
 * 480.滑动窗口中位数
 */
public class Lc480 {
    public double[] medianSlidingWindow(int[] nums, int k){
        TreeMap<Integer,Integer> map = new TreeMap<>();
        List<Double> mid = new LinkedList<>();
        for (int i = 0; i < nums.length - k + 1; i++) {
            if (i == 0){
                for (int j = 0;j < k;j++){
                    map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                }
            }else {
                map.put(nums[i - 1], map.get(nums[i - 1]) - 1);
                if (map.get(nums[i - 1]) == 0){
                    map.remove(nums[i - 1]);
                }
                map.put(nums[i + k - 1], map.getOrDefault(nums[i + k - 1], 0) + 1);
            }
            int count = 0;
            if (k % 2 == 0){
                int res = 0;
                for (int j : map.keySet()){
                    if (count == k / 2 || count == k / 2 - 1){
                        res += j;
                    }
                    count++;
                }
                for (Map.Entry<Integer,Integer> j : map.entrySet()){
                    count += j.getValue();
                    if (count > k / 2){
                        mid.add((double)j.getKey());
                    }
                }
                mid.add((double)res / 2);
            }else {
                for (Map.Entry<Integer,Integer> j : map.entrySet()){
                    count += j.getValue();
                    if (count > k / 2){
                        mid.add((double)j.getKey());
                    }
                }
            }
        }
        double[] res = new double[mid.size()];
        for (int i = 0; i < mid.size(); i++) {
            res[i] = mid.get(i);
        }
        return res;
    }
}
