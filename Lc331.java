package leetcode;

import java.util.Stack;

/**
 * @author Kuma
 * @date 2021年3月13日
 * 331. 验证二叉树的前序序列化
 */
public class Lc331 {
    public boolean isValidSerialization(String preorder) {
//        根节点入度0，出度2
        int dif = -1;
        for (String s : preorder.split(",")){
//                空节点入度1，出度0
            dif += 1;
            if (dif > 0){
                return false;
            }
            if (!"#".equals(s)){
//                普通节点入度1，出度2
                dif -= 2;
            }
        }
        return dif == 0;
    }
}
