/*
 * @lc app=leetcode id=1022 lang=java
 *
 * [1022] Sum of Root To Leaf Binary Numbers
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
    public int sumRootToLeaf(TreeNode root) {
        if(root == null) return 0;
        String sum = "";
        return dfs(sum, root);
    }

    private int dfs(String sum, TreeNode root) {
        if(root == null) return 0;
        sum +=root.val;
        if(root.left == null && root.right == null){
            return convertToDecimal(sum);
        }
        return dfs(sum, root.left) + dfs(sum, root.right);
        
    }
    public int convertToDecimal(String pathValues){
        int sum = 0;
        int length = pathValues.length();
        for(int i = 0; i < length; i++){
            sum += (Character.getNumericValue(pathValues.charAt(i)) * Math.pow(2, length - i - 1));
        }
        return sum;
    }
}
// @lc code=end

