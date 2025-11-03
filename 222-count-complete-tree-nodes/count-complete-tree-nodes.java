// Optimal (Preorder Traversal)

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
    public int countNodes(TreeNode root) {
        // If root is null return 0
        if (root == null) return 0;
        // Recursively add 1 going deep to the left and then right
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

// T.C => O(N)
// S.C => O(N)
