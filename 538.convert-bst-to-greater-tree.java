/*
 * @lc app=leetcode id=538 lang=java
 *
 * [538] Convert BST to Greater Tree
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
    // public TreeNode convertBST(TreeNode root) {
    //     if(root == null) return null;
    //     if(root.left == null && root.right == null) {
    //         return root;
    //     }
    //     helper(root, 0);

    //     return root;
    // }
    // private int helper(TreeNode root, int sum) {
    //     if(root == null) return sum;
        
    //     int right = helper(root.right, sum);
    //     root.val = root.val + right;
    //     int left=    helper(root.left, root.val);
        
    //     return left;
    // }









        /**
         * 05/02/2020: 重做
         */

    Integer sum = null;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        helper(root);
        return root;
    }
    private void helper(TreeNode root) {
        if(root == null) return;

        helper(root.right);
        if(sum != null) {
            root.val += sum;
            sum = root.val;
        } else {
            sum = root.val;
        }
        helper(root.left);
        
    }
    
}
// @lc code=end

