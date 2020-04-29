/*
 * @lc app=leetcode id=606 lang=java
 *
 * [606] Construct String from Binary Tree
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
    public String tree2str(TreeNode t) {
        // Use Preorder (Root, Left, Right) traversal
        if(t == null) return  "";
        String temp = "";
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        temp += t.val;
        if(left == "" && right == "") return temp;
        if(left == "") return temp + "()" + "(" + right + ")";
        if(right == "") return temp + "(" + left + ")";
        return temp + "(" +left + ")" + "(" + right + ")";        
    }
}
// @lc code=end

