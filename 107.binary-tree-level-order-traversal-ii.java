import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
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

    List<List<Integer>> ll = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root != null) {
            helper(root, 0);
        }
        return ll;
    }
    private void helper(TreeNode root,  int level) {
        if(root == null) return;
        if(ll.size() <= level) {
            ll.add(0, new ArrayList<>());
        }

        helper(root.left, level + 1);
        helper(root.right, level + 1);
        ll.get(ll.size() - level -1).add(root.val);

    }
}
// @lc code=end

