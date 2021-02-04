package leetcode;

/**
 * @author Kuma
 * @date 2021年2月4日
 * 643.子数组最大平均数Ⅰ
 */
public class Lc643 {
    public static double findMaxAverage(int[] nums, int k) {
        double res = 0;
        double sum = 0;
        for(int i = 0;i <= nums.length - k;i++){
            if(i == 0){
                for(int j = i;j < i + k;j++){
                    sum += nums[j];
                }
                res = sum / k;
            }else{
                sum = sum - nums[i - 1] + nums[i + k - 1];
            }
            res = Math.max(res, sum / k);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {-1};
        findMaxAverage(a,1);
    }
}
