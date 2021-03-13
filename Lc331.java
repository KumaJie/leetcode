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
// 遍历完之前，出度是大于等于入度的    1个出度认为提供一个挂载点  1个入度认为消耗一个挂载点
// 若小于等于 消耗的挂载点 大于等于 提供的挂载点  不可能再继续遍历挂载剩下的节点了
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
