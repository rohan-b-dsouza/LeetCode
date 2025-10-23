// Recursive (Postorder Traversal)

// Why Postorder pattern is observed here? -> 
// 1. Go left first → maxDepth(root.left)
// 2. Go right next → maxDepth(root.right)
// 3. Process current node → 1 + Math.max(left, right)

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
    public int maxDepth(TreeNode root) {
        // If root is null, return 0
        if (root == null) return 0;
        // Count the current node + max of left and right subtree
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

// T.C => O(n) as we visit all the nodes
// S.C => O(n) for recursive stack space in worst case (i.e skewed B.T) and O(log (n)) for Balanced B.T
