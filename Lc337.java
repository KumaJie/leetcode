package leetcode;

/**
 * @author Kuma
 * @date 2021年4月15日
 * 337.打家劫舍 III
 */
public class Lc337 {
    public int rob(TreeNode root) {
        int[] dp = dfs(root);
        return Math.max(dp[0], dp[1]);
    }

    /**
     *
     * @param root 树
     * @return 返回一个二元数组，dp[0]不拿,dp[1]拿；值分别代表当前状态下最大数量
     */
    public int[] dfs(TreeNode root){
        if (root == null){
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] dp = new int[2];
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = root.val + Math.max(left[0], right[0]);
        return dp;
    }
}

class TreeNode {
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

