package leetcode;

import java.util.LinkedList;

/**
 * @author Kuma
 * @date 2021年3月3日
 * 6. Z字形变换
 */
public class Lc6 {
    public String convert(String s, int numRows) {
        if (numRows < 2){
            return s;
        }
        LinkedList<StringBuffer> str = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            str.push(new StringBuffer());
        }
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()){
            str.get(i).append(c);
            if (i == numRows - 1 || i == 0){
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuffer t : str){
            res.append(t);
        }
        return res.toString();
    }
}
