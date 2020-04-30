/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
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
    public TreeNode sortedArrayToBST(int[] nums) {
        int i = 0, j = nums.length -1;
        int mid = nums.length /2;
        TreeNode root =  helper(i, j, nums);
        return root;
    }
    private TreeNode helper( int i, int j, int[] nums) {
        if(i > j) return null;

        int mid = i+((j-i) / 2);
        TreeNode temp = new TreeNode(nums[mid]);
        temp.left = helper(i, mid-1, nums);
        temp.right = helper(mid+1, j, nums);
        return temp;
    }
}
// @lc code=end

