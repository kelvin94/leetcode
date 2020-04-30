/*
 * @lc app=leetcode id=671 lang=java
 *
 * [671] Second Minimum Node In a Binary Tree
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
    Integer smallest = null;
    Integer secondsmallest = null;
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null) return -1;
        helper(root);
        return (secondsmallest != null) ? secondsmallest : -1;
    }
    private void helper(TreeNode root) {
        if(root == null) return;
        if(this.smallest == null) 
            this.smallest = root.val;
        else if(this.smallest != null && root.val < smallest) {
            // in the case we see a smaller "smallest" number in the later of the time
            smallest = root.val;
        }

        if(secondsmallest == null && root.val > smallest) {
            secondsmallest = root.val;
        } else if(secondsmallest != null 
                && root.val < secondsmallest
                && root.val > smallest) {
            // in the case we see a smaller "secondsmallest" number in the later of the time
            secondsmallest = root.val;
        }
        findSecondMinimumValue(root.left);
        findSecondMinimumValue(root.right);
    }
}
// @lc code=end

