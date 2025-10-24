// Brute (Preorder)

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
    // Function to get the height of the subtrees
    public int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
         // If root is null return 0
        if (root == null) return 0;
        // Get the left and right subtree height for current node
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        // Compute the path length taking current node as pivot)
        int diameter = leftHeight + rightHeight;
        // Recursively compute the path lengths by taking each node as pivot and return the maximum path length (diameter of the B.T)
        return Math.max(Math.max(diameterOfBinaryTree(root.left), diameter), diameterOfBinaryTree(root.right));
    }
}

// T.C => O(n ^ 2) as for each node we compute the height of its left and right subtree
// S.C => O(2 * n) = O(n) as two recursion stacks will be reqd one for maxDepth func calls and one for diameterOfBinaryTree() func calls
