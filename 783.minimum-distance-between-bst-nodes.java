/*
 * @lc app=leetcode id=783 lang=java
 *
 * [783] Minimum Distance Between BST Nodes
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Integer min = Integer.MAX_VALUE;
    Integer pre = null;
    // public int minDiffInBST(TreeNode root) {
    //     if(root ==null) return 0;
    //     helper(root);
    //     return min;
    // }
    // private void helper(TreeNode root) {
    //     if(root == null) return;
    //     helper(root.left);
    //     if(pre != null)
    //         min = Math.min(min, root.val - pre);
    //     pre = root.val;
    //     helper(root.right);
        

    // }

























    public int minDiffInBST(TreeNode root) {
        if(root != null) 
            helper(root, -1);
        return min;
    }
    private void helper(TreeNode root, int parent_val) {
        if(root == null) return;

        helper(root.left, root.val);
        if(pre != null)
            min = Math.min(min, root.val-pre );
        pre = root.val;
        helper(root.right, root.val);
    }

}
// @lc code=end

