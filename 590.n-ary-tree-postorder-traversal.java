import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=590 lang=java
 *
 * [590] N-ary Tree Postorder Traversal
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
    public List<Integer> postorder(Node root) {
        // Postorder (Left, Right, Root)
        List<Integer> l = new ArrayList<>();
        if(root == null) return l;
        for(Node node : root.children) {
            l.addAll(postorder(node));
        }
        l.add(root.val);
        // postorder(root.left);
        return l;
    }
}
// @lc code=end

