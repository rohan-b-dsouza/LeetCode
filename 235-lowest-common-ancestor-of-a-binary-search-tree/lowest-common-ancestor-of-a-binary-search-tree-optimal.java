// Optimal

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        // While curr is not null
        while (curr != null) {
            // If p and q both lie on left subtree, move left
            if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            }
            // If p and q both lie on right subtree, move right
            else if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            }
            // If p and q lie on different subtrees or if the curr node itself is one of p or q 
            else {
                // Return curr node
                return curr;
            }
        }
        return null;
    }
}

// T.C => O(h) ----- {h = log (n) for a balanced BST, h = n for a skewed BST}
// S.C => O(1)
