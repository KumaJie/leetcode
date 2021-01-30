package leetcode;

/**
 * @author Kuma
 * @date 2021年1月30日
 * 338. 比特位计数
 */
public class Lc338 {
    public int[] countBits(int num) {
//        高级
//        int[] bp = new int[num + 1];
//        int i = 0;
//        int b = 1;
//        while (b <= num){
//            while (i < b && i + b <= num){
//                bp[i + b] = bp[i++] + 1;
//            }
//            i = 0;
//            b <<= 1;
//        }
//        return bp;
//        奇偶性质
        int[] bp = new int[num + 1];
        for (int i = 1; i < bp.length; i++) {
            if(i % 2 == 0){
                bp[i] = bp[i / 2];
            }else {
                bp[i] = bp[i - 1] + 1;
            }
        }
        return bp;
    }
}
