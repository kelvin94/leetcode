import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
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
    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum(0, 1);
        helper(root, 0, sum, map);
    }
    private int helper(TreeNode root, int currSum, int target, Map<Integer,Integer> preSum) {
        if (root == null) {
            return 0;
        }
        
        currSum += root.val;
        /**
        * For an array [2, -1, 3, -2, 1], given the targer value tar = 1, if you were asked to find out all subarrays whose sum equals to tar, what will you do?
The basic idea is that, let sum[i] be the sum of elements from 0 to i; Then sum[j] - sum[i] is the sum of elements from i to j; if sum[j] - sum[i] = tar, then the subarray of [i, j] is one of the expected array. If you store sum[i] in a HashMap with key sum[i] and frequence f, every time you estimate new sum[j], you just need to check if the HashMap contains the key sum[j] - tar, if it does, then we will have f different ways to get the tar.
        */

        // "currSum - target" explanation: In a prefix sum array, sum(a,b) = sum(0, b) - sum(0, a-1) is the same as sum(0, a-1) = sum(0, b) - sum(a,b) where currSum = sum(0, b) and target is sum(a,b). a and b are indices in the array. Note that currSum is the prefix sum, i.e. the sum of all node values (from its ancestors to that node).
        int res = preSum.getOrDefault(currSum - target, 0); // this line gets the the frequency of a path currentSum - oldPathSum = target, a path starting from root to some node we have been before
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1); // "every time you estimate new sum[j], you just need to check if the HashMap contains the key sum[j] - tar, if it does, then we will have f different ways to get the tar.""
        
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;

    }
}
// @lc code=end

