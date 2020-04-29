/*
 * @lc app=leetcode id=530 lang=java
 *
 * [530] Minimum Absolute Difference in BST
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
    int min = Integer.MAX_VALUE;
    Integer pre = null;
    public int getMinimumDifference(TreeNode root) {
        // in-order traversal
        if(root == null) return 0;
        helper(root);
        return min;
    }
    private void helper(TreeNode root) {
        if(root == null) return;
        helper(root.left);

        if(pre != null)
            min = Math.min(min, Math.abs(root.val-pre));
        pre = root.val; 
        helper(root.right);
    }
}
// @lc code=end

