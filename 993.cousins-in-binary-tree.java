import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=993 lang=java
 *
 * [993] Cousins in Binary Tree
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
    
    class Node{
        TreeNode parentNode;
        TreeNode node;
        int depth;
        Node(TreeNode parentNode, TreeNode node, int depth) {
            this.parentNode = parentNode;
            this.node = node;
            this.depth = depth;
        }
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        // // Solution-1: find each node's parent, and each node's depth, then comapre their parent and depth
        // TreeNode xP = findParent(root,x);
        // TreeNode yP = findParent(root,y);
        // int xDepth = getDepth(root, x,0);
        // int yDepth = getDepth(root, y,0);
        // if(xP != null && yP != null) {
        //     if(xP == yP) return false;
        //     else {
        //         if(xDepth == yDepth) return true;
        //         return false;
        //     }
        // }
        // return false;


        // Solution-2 : Create a new class which keep track of node's height(depth) and recording the parent of each node at the same time - Use BFS
        if(root == null) return false;
        Node xnode = find(root, x);
        Node ynode = find(root, y);
        if((xnode!=null && ynode!= null))
            // 错误2： 我们自己定义的Node class里的"parentNode" field是TreeNode type，这个field有可能是null - 这种情况是当 x 或者 y是tree的最顶端的node的时候
            if((xnode.parentNode != null && ynode.parentNode != null)
                && (xnode.parentNode.val != ynode.parentNode.val) 
                && (xnode.depth == ynode.depth)) {
                return true;
        }
        
        return false;
    }
    

    private Node find(TreeNode root, int target) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(null, root, 0));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node temp = q.poll();
                if(temp.node.val == target) 
                    return temp; // 错误1：如果发现之前insert到queue里面的node就是target的话我们应该直接return temp
                if(temp.node.left != null) {
                    
                    q.offer(new Node(temp.node, temp.node.left, temp.depth+1));
                } 
                if(temp.node.right != null) {
                    q.offer(new Node(temp.node, temp.node.right, temp.depth+1));
                }

            }
        }
        return null;
    }


    private int getDepth(TreeNode root, int k, int count) {
        if(root == null) return 0;
        if(root.val == k) return count;
        return Math.max(getDepth(root.left,k, count+1), getDepth(root.right,k, count+1)); 
        
    }
    private TreeNode findParent(TreeNode n, int target){
        if(n == null) return null;
        if((n.left != null && n.left.val == target)
                || (n.right != null && n.right.val == target)) {
            return n;
        }
        TreeNode left = findParent(n.left, target);
        TreeNode right = findParent(n.right, target);
        if(left == null && right == null) return null;
        else if(left != null) return left;
        else if(right != null) return right;
        else return null;
    }
}
// @lc code=end

