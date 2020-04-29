/*
 * @lc app=leetcode id=559 lang=java
 *
 * [559] Maximum Depth of N-ary Tree
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int max = 0;
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int localMax = 0;
        for(Node node : root.children) {
            int temp = maxDepth(node);
            if(localMax < temp) localMax = temp;
        }
        max = Math.max(localMax,max);
        return localMax+1;
    }
    

    
}
// @lc code=end

