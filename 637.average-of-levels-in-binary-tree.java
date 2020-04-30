import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=637 lang=java
 *
 * [637] Average of Levels in Binary Tree
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
    List<Double> ll = new ArrayList<>();

    class Node{
        int count;
        Double sum;
        Node (double d, int c) {
            sum = d;
            count = c;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Node> l = new ArrayList<>();
        dfs(root, l, 0);
        List<Double> res = new ArrayList<>();
        for(Node node : l) {
            res.add(node.sum / node.count);
        }
        return res;
    }
 
    private void dfs(TreeNode root,List<Node> nodes,
    int level) {
        if(root == null ) return;
        if(nodes.size() == level) {
            nodes.add(new Node((double)root.val, 1));
        } else {
            nodes.get(level).count++;
            nodes.get(level).sum += root.val;
        }

        dfs(root.left,nodes, level+1);
        dfs(root.right,nodes, level+1);

    }
}
// @lc code=end

