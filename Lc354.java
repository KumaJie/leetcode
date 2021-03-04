package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Kuma
 * @date 2021年3月4日
 * 354.俄罗斯套娃信封问题
 */
public class Lc354 {
    public int maxEnvelopes(int[][] envelopes) {
        ArrayList<int[]> env = new ArrayList<>();
        for (int i = 0; i < envelopes.length; i++) {
            env.add(new int[2]);
            env.get(i)[0] = envelopes[i][0];
            env.get(i)[1] = envelopes[i][0];
        }
        env.sort(((o1, o2) -> {
            if (o1[0] == o2[0]){
                return o2[1] - o1[1];
            }else {
                return o1[0] - o2[0];
            }
        }));
        int[] bp = new int[env.size()];
        Arrays.fill(bp, 1);
        int max = 1;
        for (int i = 0; i < env.size(); i++) {
            int h = env.get(i)[1];
            for (int j = 0; j < i; j++) {
                int hh = env.get(j)[1];
                if (hh < h){
                    bp[i] = Math.max(bp[i], bp[j] + 1);
                }
            }
            max = Math.max(bp[i], max);
        }
        return max;
    }
}
