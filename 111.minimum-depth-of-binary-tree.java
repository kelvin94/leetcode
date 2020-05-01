/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
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
    // public int minDepth(TreeNode root) {
    //     if(root == null) return 0;
    //     if(root.left == null && root.right == null) return 1;
    //     if(root.left == null)  return 1+minDepth(root.right);
    //     if(root.right == null)  return 1+ minDepth(root.left);
        
    //     return 1+Math.min(minDepth(root.left), minDepth(root.right));
    // }




























    public int minDepth(TreeNode root) {
        // Solution-1: similar to getMaxHeight() question but we want to find "minHeight". there is a case when we meet a null node as child, the depth of this child would be 0. So we should not simply do "Math.min(left,right)" because when a child is null node it returns 0 as the depth.
        // Hence if one of the child is null node, we simply ignore it and add both "left+right".
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int left = minDepth(root.left);
        
        int right = minDepth(root.right);
        // left or right equals to 0 meaning - "left or right subtree is empty, the minDepth of myself should not take 0 as the result to be returned"
        return (left == 0 || right == 0) ? left + right + 1 : 1+Math.min(left, right);





    
    }
}
// @lc code=end

