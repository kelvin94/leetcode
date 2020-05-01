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

    // List<List<Integer>> ll = new ArrayList<>();
    // public List<List<Integer>> levelOrderBottom(TreeNode root) {
    //     if(root != null) {
    //         helper(root, 0);
    //     }
    //     return ll;
    // }
    // private void helper(TreeNode root,  int level) {
    //     if(root == null) return;
    //     if(ll.size() <= level) {
    //         ll.add(0, new ArrayList<>());
    //     }

    //     helper(root.left, level + 1);
    //     helper(root.right, level + 1);
    //     ll.get(ll.size() - level -1).add(root.val);

    // }





















    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ll = new ArrayList<>();
        if(root == null) return ll;
        helper(root, ll, 0);
        return ll;
    }
    private void helper(TreeNode root, List<List<Integer>> ll, int level) {
        if(root == null) return;
        if(ll.size() <= level) {
            ll.add(0, new ArrayList<>());
        }
        
        
        helper(root.left, ll, level+1);
        

        helper(root.right, ll, level+1);
        // Understanding of "ll.size() - level - 1": Since we add elements to a list, if we always want to keep track of where a specific element is, we can remember it as the "the nth element from the tail", Example is see the "index=1('b' element)" element moves when the list "[a,b,c]" expanded to be "[z,a,b,c]", 'b' is always the 2nd element from the tail.
        ll.get(ll.size() - level - 1).add(root.val);
    }
}
// @lc code=end

