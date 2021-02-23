package leetcode;

/**
 * @author Kuma
 * @date 2021年2月23日
 * 1052. 爱生气的书店老板
 */
public class Lc1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int res = 0;
        int num = 0;
        for (int i = 0; i < customers.length - X + 1; i++) {
//            初始窗口
            if (i == 0){
                for (int j = 0; j < customers.length; j++) {
                    if (j < X){
                        num += customers[j];
                    }else {
                        num += grumpy[j] == 0 ? customers[j] : 0;
                    }
                }
            }else {
//                滑动
                num -= grumpy[i -1] == 1 ? customers[i - 1] : 0;
                num += grumpy[i + X - 1] == 1 ? customers[i + X - 1] : 0;
            }
            res = Math.max(res, num);
        }
        return res;
    }
}
