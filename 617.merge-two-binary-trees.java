/*
 * @lc app=leetcode id=617 lang=java
 *
 * [617] Merge Two Binary Trees
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        if(t1 == null && t2 != null) return t2;
        if(t1 != null && t2 == null) return t1;

        TreeNode newroot = merge( t1, t2);
        return newroot;
    }
    private TreeNode merge( TreeNode t1, TreeNode t2) {
        TreeNode node = new TreeNode();
        if(t1 == null && t2 == null) return null;

        if(t1 == null && t2 != null) {
            node.val = t2.val;
            node.left = merge(t2.left, null);
            node.right = merge(t2.right, null);
        }
        else if(t1 != null && t2 == null) {
            node.val = t1.val;
            node.left = merge(t1.left, null);
            node.right = merge(t1.right, null);
        }
        else {
            node.val = t1.val + t2.val;
            node.left = merge(t1.left, t2.left);
            node.right = merge(t1.right, t2.right);
        }
        
        return node;
    }
}
// @lc code=end

