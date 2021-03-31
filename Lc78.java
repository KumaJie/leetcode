package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kuma
 * @date 2021年3月31日
 * 78. 子集
 */
public class Lc78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backTrack(nums, 0, res, tmp);
        return res;
    }

    public void backTrack(int[] nums, int i,List<List<Integer>> res,List<Integer> tmp){
        if (!res.contains(tmp)){
            res.add(new ArrayList<>(tmp));
        }
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backTrack(nums,j+1,res,tmp);
            tmp.remove(new Integer(nums[j]));
        }
    }
}
