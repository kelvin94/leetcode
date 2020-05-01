import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=872 lang=java
 *
 * [872] Leaf-Similar Trees
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // if(root1 == null && root2 == null) return true;
        // if(root1 == null ^ root2 == null) return false;
        
        // Solution - 1: write a helper function which generate the leaf value sequence for a tree. Then return the comparison result of the  sequence of two trees 
        // List<Integer> l1 = new ArrayList<>();
        // List<Integer> l2 = new ArrayList<>();
        // helper(root1, l1);
        // System.out.println(l1.toString());
        // helper(root2, l2);
        // System.out.println(l2.toString());
        // if(l1.size() == l2.size()) {
        //     for(int i = 0; i < l1.size(); i++) {
        //         if(l1.get(i) != l2.get(i)) return false;
        //     }
        //     return true;
        // }
        // return false;





        // Solution - 2 : for each iteration, we find the leaf of both trees using pre-order traversal, then compare both leaf.
        // if(root1 == null && root2 == null) return true;
        // if(root1 == null ^ root2 == null) return false;
        // Stack<TreeNode> s1 = new Stack<>(), s2 = new Stack<>();
        // s1.push(root1);
        // s2.push(root2);
        // while(!s1.isEmpty() && !s2.isEmpty()) {
        //     if(dfs(s1) != dfs(s2)) return false;
        // }
        // return s1.isEmpty() && s2.isEmpty() ? true : false;



        // Solution-3: Use Stringbuilder - for each tree, record each lefe in the String builder; Generate two strings which are the leaf sequences in String, then compare the Two strings as the result; An edge case for using StringBuilder here: [1,2,23] and [1,223], if we use string builder here we will get result to be "true" but the expected result is falses
        if(root1 == null && root2 == null) return true;
        if(root1 == null ^ root2 == null) return false;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        leafBuilder(root1, sb1);
        leafBuilder(root2, sb2);
        return sb1.toString().equals(sb2.toString());
    }

    private void leafBuilder(TreeNode node, StringBuilder sb) {
        if(node == null) return;
        if(node.left == null && node.right == null) 
            sb.append(node.val+"-");
        leafBuilder(node.left, sb);
        leafBuilder(node.right, sb);
    }

    private int dfs( Stack<TreeNode> stack) {
        // keep running dfs till we find a leaf
        while(true) {
            TreeNode s = stack.pop();
            // travere the tree in pre-order traversal
            if(s.left != null) stack.push(s.left);
            if(s.right != null) stack.push(s.right);
            if(s.left == null && s.right == null) return s.val;
        }
        
    }

    private boolean isLeaf(TreeNode leaf) {
        if(leaf == null) return false;
        return leaf.left == null && leaf.right == null;
    }
    private void helper(TreeNode root, List<Integer> l) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            l.add(root.val);
        }
        helper(root.left, l);
        helper(root.right, l);
    }
}
// @lc code=end

