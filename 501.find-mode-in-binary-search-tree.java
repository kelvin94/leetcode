import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=501 lang=java
 *
 * [501] Find Mode in Binary Search Tree
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
    List<Integer> l = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    Integer max = 0;
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[]{};
        if(root.left == null && root.right == null) return new int[]{root.val};
        helper(root);
        
        for(int key: map.keySet()){
            if(map.get(key) == max) l.add(key);
        }

        int[] m = new int[l.size()];
        int i = 0;
        for(Integer ll : l){
            m[i++] = ll;
        }
        return m;
    }
    private void helper(TreeNode root) {
        if(root == null) return;
        map.put(root.val, map.getOrDefault(root.val,1)+1);
        max = Math.max(max, map.get(root.val));
        
        helper(root.left);
        helper(root.right); 
    }
}
// @lc code=end

