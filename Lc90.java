package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kuma
 * @date 2021年3月31日
 * 90. 子集 II
 */
public class Lc90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            backTrack(nums,0,i,res,tmp);
        }
        return res;
    }

    public static void backTrack(int[] nums,int i,int n,List<List<Integer>> res,List<Integer> tmp){
        if (tmp.size() == n){
            if (!res.contains(tmp)){
                res.add(new ArrayList<>(tmp));
            }
            return;
        }
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backTrack(nums,j+1,n,res,tmp);
            tmp.remove(new Integer(nums[j]));
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        subsetsWithDup(a);
    }
}
