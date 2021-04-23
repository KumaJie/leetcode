package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kuma
 * @date 2021年4月23日
 * 368.最大整除子集
 */
public class Lc368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> bp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bp.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && bp.get(j).size() > bp.get(i).size()){
                    bp.get(i).clear();
                    bp.get(i).addAll(bp.get(j));
                }
            }
            bp.get(i).add(nums[i]);
        }
        bp.sort(((o1, o2) -> o2.size() - o1.size()));
        System.out.println(bp.get(0));
        return bp.get(0);
    }
}
