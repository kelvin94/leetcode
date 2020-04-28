import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> l = new ArrayList<>();
        if(root == null) return l;
        helper(root, "", l);
        return l;
        
    }
    private void helper(TreeNode root, String path, List<String> answer) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            answer.add(path + root.val);            
        }
        if(root.left != null) {
            helper(root.left, path + root.val +"->"  , answer);
        }
        if(root.right != null) {
            helper(root.right, path + root.val + "->", answer);
        }
        
    }
}
// @lc code=end

