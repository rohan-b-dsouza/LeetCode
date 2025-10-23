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
    public int maxDepth(TreeNode node) {
		// If node is null, return 0
        if (node == null) return 0;
		// Recursively get the height of the left subtree
        int left = maxDepth(node.left);
		// If left is -1 at any point, it means tree is not balanced hence return -1
        if (left == -1) return -1;
		// Recursively get the height of the right subtree
        int right = maxDepth(node.right);
        // If left is -1 at any point, it means tree is not balanced hence return -1
		if (right == -1) return -1;
		// Check if tree is balanced, if not return -1
        if (Math.abs(left - right) > 1) return -1;
		// Return the height of current subtree
        return 1 + Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
		// If the helper function maxDepth returns -1, it means tree is not balanced else it's balanced
        return maxDepth(root) != -1;
	}
}

// T.C => O(n) as we visit each node once
// S.C => O(n) in worst case for a skewed B.T and O(log (n)) in best case for a balanced B.T
