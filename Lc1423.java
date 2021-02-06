package leetcode;

/**
 * @author Kuma
 * @date 2021年2月6日
 * 1423.可获得的最大点数
 */
public class Lc1423 {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int windowSize = len - k;
        int sum = 0;
        for(int i : cardPoints){
            sum += i;
        }
        int res = 0;
        int sumSubArr = 0;
        for(int i = 0;i < len && i + windowSize <= len;i++){
            if(i == 0){
                for(int j = 0;j < windowSize;j++){
                    sumSubArr += cardPoints[j];
                }
            }else{
                sumSubArr = sumSubArr - cardPoints[i - 1] + cardPoints[i + windowSize - 1];
            }
            res = Math.max(res, sum - sumSubArr);
        }
        return res;
    }
}
