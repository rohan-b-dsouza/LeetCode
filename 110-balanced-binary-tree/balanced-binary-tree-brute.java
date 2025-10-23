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
	// Get the height of this subtree using maxDepth function
    public int maxDepth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
        
    }
    public boolean isBalanced(TreeNode root) {
		// If root is null, return true
        if (root == null) return true;
		// Check if tree is balanced at this node
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) {
            return false;
        }
		// Recursively check all nodes first left nodes then right nodes
        return isBalanced(root.left) && isBalanced(root.right);
	}
}

// T.C => O(2 * (n ^ 2)) = O(n ^ 2) as there are total n nodes and for each node we calculate height of left as well as right subtree
// S.C => O(2 * n) = O(n) as there are 2 recursive stacks, considering worst case i.e Skewed B.T , Best Case : O(2 * log (n)) = O(log (n))
