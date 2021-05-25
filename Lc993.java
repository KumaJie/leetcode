package leetcode;

/**
 * @author Kuma
 * @date 2021年5月25日
 * 993.二叉树的堂兄弟节点
 */

import com.sun.corba.se.impl.naming.cosnaming.NamingUtils;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Lc993 {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    static TreeNode pre;

    public boolean isCousins(TreeNode root, int x, int y) {
        int depX = find(root,x);
        TreeNode preX = pre;
        pre = null;
        int depY = find(root, y);
        TreeNode preY = pre;
        return depX == depY && preX != preY;
    }

    int find(TreeNode root, int x){
        if (root == null){
            return 0;
        }
        int l = find(root.left, x);
        int r = 0;
        if (root.left != null && root.left.val == x || root.right != null && root.right.val == x){
            pre = root;
            return 1;
        }
        if (l == 0){
            r = find(root.right, x);
        }
        int depth = Math.max(l,r);
        return depth == 0 ? 0 : depth + 1;
    }
}
