/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */

// @lc code=start
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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left,root.right);
    }

    private boolean helper(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null ^ q == null) return false;
        if(p.val != q.val ) return false;

        boolean leaft = helper(p.left, q.right);
        boolean right = helper(p.right, q.left);
        return leaft && right;

    }
}
// @lc code=end

