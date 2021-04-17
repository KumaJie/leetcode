package leetcode;

import java.util.HashSet;

/**
 * @author Kuma
 * @date 2021年4月17日
 * 217.存在重复元素
 */
public class Lc217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums){
            if (!set.contains(i)){
                set.add(i);
            }else{
                return true;
            }
        }
        return false;
    }
}
