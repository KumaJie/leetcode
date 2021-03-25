package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Kuma
 * @date 2021年3月25日
 * 986. 区间列表的交集
 */
public class Lc986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        ArrayList<int[]> res = new ArrayList<>();
        int firstLen = firstList.length;
        int secondLen = secondList.length;
        while (i < firstLen && j < secondLen){
//            有交集
            if (firstList[i][0] <= secondList[j][1] && firstList[i][1] >= secondList[j][0]){
                res.add(new int[]{Math.max(firstList[i][0],secondList[j][0]), Math.min(firstList[i][1],secondList[j][1])});
            }
            if (firstList[i][1] < secondList[j][1]){
                i++;
            }else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
