/*
 * @lc app=leetcode id=687 lang=java
 *
 * [687] Longest Univalue Path
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
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        helper(root, -1);
        return max;
        
    }
    int max = 0;
    private int helper(TreeNode root, Integer val) {
        if(root == null) return 0;
        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);
        
        max = Math.max(max, left + right); // if left has some value meaning the left subtree has the same value as in the current node, same as right subtree
        int count = 0;
        if(root.val == val)
            count = 1+ Math.max(left, right);
        return count;
    }
}
// @lc code=end

