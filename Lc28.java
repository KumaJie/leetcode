package leetcode;

/**
 * @author Kuma
 * @date 2021年4月20日
 * 28.实现 strStr()
 */
public class Lc28 {
    public static int[] next(String needle) {
        int i = 0;
        int j = -1;
        int[] next = new int[needle.length()];
        next[0] = -1;
        while (i < next.length - 1) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            }else{
                j = next[j];
            }
        }
        return next;
    }

    public static int strStr(String haystack, String needle){
        if (needle.length() == 0) return 0;
        int[] next = next(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length()){
            while (i < haystack.length() && j < needle.length()){
                if (haystack.charAt(i) != needle.charAt(j)){
                    break;
                }
                i++;
                j++;
            }
            if (j == needle.length()){
                return i - j;
            }
            if (next[j] == -1){
                i++;
                j = 0;
            }else {
                j = next[j];
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "issip";
        String tar = "mississippi";
        System.out.println(strStr(tar, str));
    }
}
