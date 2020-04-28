import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        if(root.left == null && root.right == null) {
            if(root.val == sum) res.add(Arrays.asList(root.val));
            return res;
        }
        List<List<Integer>> lefts = helper(root.left, sum - root.val);
        List<List<Integer>> rights = helper(root.right, sum - root.val);
        if(lefts != null && !lefts.isEmpty()){
            for(List<Integer> left : lefts) 
                left.add(0, root.val);
            res.addAll(lefts);
        }
        if(rights != null && !rights.isEmpty()){
            for(List<Integer> right : rights)
                right.add(0, root.val);
            res.addAll(rights);
        }
        
        return res;
    }

    private List<List<Integer>> helper(TreeNode root, int sum) {
        if(root == null) return null;
        List<List<Integer>> ll = new ArrayList<>();
        if(root.left == null && root.right == null) {
            List<Integer> l = new ArrayList<>();
            if(root.val == sum) {
                l.add(root.val);
                ll.add(l);

            }
            return ll;
        }
        List<List<Integer>> lefts = helper(root.left, sum - root.val);

        List<List<Integer>> rights = helper(root.right, sum - root.val);

        if(lefts != null && !lefts.isEmpty() ) {
            for(List<Integer> left : lefts) 
                left.add(0, root.val);
            ll.addAll(lefts);

        }
        if(rights != null && !rights.isEmpty() )  {
            for(List<Integer> right : rights)
                right.add(0, root.val);
            ll.addAll(rights);

        }

        // System.out.println(root.val);

        // System.out.println(left);
        // System.out.println(right);
        // System.out.println("\n");

        return ll;
    }
}
// @lc code=end

