/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
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
    // public boolean hasPathSum(TreeNode root, int sum) {
    //     if(root == null) return false;
    //     if(root.left == null && root.right == null && root.val == sum) return true;
        
    //     boolean left = hasPathSum(root.left, sum - root.val);

    //     boolean right = hasPathSum(root.right, sum - root.val);
    //     return left || right;
        
    // }





























    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null
            && root.val == sum){
                return true;
            }
        
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum- root.val);
    }
}
// @lc code=end

