import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=653 lang=java
 *
 * [653] Two Sum IV - Input is a BST
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
    Integer pre = null;
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> l = new ArrayList<>();
    TreeNode root;

    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        
        // boolean left = findTarget(root.left, k);
        // if(map.containsKey(root.val)) return true;
        // // if(root.val < k)
        //     map.put(k - root.val, root.val - k);
        // // else 
        // //     map.put(root.val - k, root.val - k);
        // boolean right = findTarget(root.right, k);
        // return left || right;

        /**
         * Solution - 2: obtain a sorted array from BST, then use 2 pointers one from the head of the sorted array looping to the tail, one pointer start from the tail of the sorted array looping to the head, see if head + tail = target value;
         */
        // formSortedArray(root);
        // for(int i = 0, j = l.size()-1; i<j;) {
        //     if(l.get(i) + l.get(j) == k) return true;
            
        //     if(l.get(i)  + l.get(j) < k) i++;
        //     else j--;
        // }
        // return false;

        /**
         * SOltuion 3: Using binary search for (k - root.val).
         */
        if(this.root == null) this.root = root;
        if(root == null) return false;
        if(search(root, k - root.val)) return true;
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    private boolean search(TreeNode node, int k) {
        TreeNode current = this.root; // start searching from the root of the tree
        while(current != null) {

            // current node value is too small, search left subtree
            if(current.val < k) current = current.right;
            // current node value is too large, search right subtree
            else if(current.val > k) current = current.left;
            // we find a node with our target value but we need to check if it is the same as the node we start the searching
            else return (current == node) ? false : true; // avoid returning myself, see the example in the problem: if target value  is 5, then when we execute "search(node with value 5, target = 5)" we will return true but this is not what we want - we want sum of 2 different nodes' value.
            
        }
        return false;
    }
    
    private void formSortedArray(TreeNode root) {
        if(root == null) return;
        formSortedArray(root.left);
        l.add(root.val);
        formSortedArray(root.right);
    }
}
// @lc code=end

