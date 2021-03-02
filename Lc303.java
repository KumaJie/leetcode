package leetcode;

/**
 * @author Kuma
 * @date 2021年3月2日
 * 303. 区域和检索 - 数组不可变
 */
public class Lc303 {
}
class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        this.sum = new int[nums.length+1];
        for(int i = 0;i < nums.length;i++){
            sum[i+1] += nums[i]+sum[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1]-sum[i];
    }
}