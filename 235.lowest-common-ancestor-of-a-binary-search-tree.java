/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        
        if(root.val == p.val || root.val == q.val) {
            return root;
        }

        // if root.val > both p and q, lowestCommonAncestor(root.left)
        if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if(root.val < q.val && root.val < p.val){
            // else if root.val < both p and q, then lowestCommonAncestor(root.left)
            return lowestCommonAncestor(root.right, p, q);
        } else {
            // else q < root.val < p OR p < root.val < q
            return root;
        }        

        
    }
}
// @lc code=end

