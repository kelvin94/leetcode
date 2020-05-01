/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
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
    // public boolean isBalanced(TreeNode root) {
    //     if(root == null) return true;
    //     int left = helper(root.left);
    //     int right = helper(root.right);
    //     if(left == -1 || right == -1) return false;
    //     return Math.abs(left - right) <= 1;
    // }

    // private int helper(TreeNode root) {
    //     if(root == null) return 0;
    //     int left = helper(root.left);
    //     int right = helper(root.right);
    //     if(Math.abs(left - right) > 1) return -1;
    //     if(left == -1 || right == -1) return -1;
    //     return 1+Math.max(left, right);
    // }







    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        // int leftHeight = getHeight(root.left);
        // int rightHeight = getHeight(root.right);
        
        // if(Math.abs(leftHeight - rightHeight) > 1) return false;

        // return isBalanced(root.left) && isBalanced(root.right);
        
        
        return helper(root) == -1 ? false : true;
    }

    private int getHeight(TreeNode root) {
        if(root == null) return 0;
        return 1+Math.max(getHeight(root.left), getHeight(root.right));
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;
        
        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);
        if(leftHeight == -1 || rightHeight == -1) return -1;
        if(Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1+Math.max(leftHeight, rightHeight);

    }




}
// @lc code=end

