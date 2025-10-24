// Optimal (Postorder)

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
    public int maxDepth(TreeNode node, int[] diameter) {
        // If node is null return 0
        if (node == null) return 0;
        // Recursively compute the height of left subtree
        int left = maxDepth(node.left, diameter);
        // Recursively compute the height of right subtree
        int right = maxDepth(node.right, diameter);
        // Compute the path length keeping current node as pivot and update maximum path length seen so far
        diameter[0] = Math.max(diameter[0], left + right);
        // Return the current max depth (height)
        return 1 + Math.max(left, right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        // Array of size 1 which helps in keeping track of the maximum path length
        // We avoid use of global variable for safety
        int[] diameter = new int[1];
        // Call the maxDepth Recursive function
        maxDepth(root, diameter);
        // Return the diameter of the B.T
        return diameter[0];
    }
}

// T.C => O(n) as we visit each node once
// S.C => O(1)
