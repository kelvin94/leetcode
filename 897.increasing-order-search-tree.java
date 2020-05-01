/*
 * @lc app=leetcode id=897 lang=java
 *
 * [897] Increasing Order Search Tree
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
    TreeNode n = null;
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return null;
        
        helper(root,null);
        return n;
        
    }
    // "Next" node is the next largest node 
    private TreeNode helper(TreeNode root, TreeNode next) {
        if(root == null){ return next; }
        TreeNode temp = helper(root.left, root);
        root.left = null;
        root.right = helper(root.right, next);
        return root;
    }
}
// @lc code=end

