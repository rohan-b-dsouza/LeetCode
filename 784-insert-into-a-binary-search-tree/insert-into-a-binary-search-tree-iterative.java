// Iterative

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

    public TreeNode insertIntoBST(TreeNode root, int val) {
        // If root is null, create and return a node with the target value
        if (root == null)
            return new TreeNode(val);
        // Get the root node
        TreeNode node = root;
        // While node is not null
        while (node != null) {
            // If val is smaller than current node's value 
            if (val < node.val) {
                // If left node is not null, move left
                if (node.left != null) {
                    node = node.left;
                // Else 
                } else {
                    // Create a node with the target value and link it to current node's left, also break out from the loop
                    node.left = new TreeNode(val);
                    break;
                }
            // Else 
            } else {
                // If right node is not null, move right
                if (node.right != null) {
                    node = node.right;
                // Else 
                } else {
                    // Create a node with the target value and link it to the current node's right, also break out from the loop
                    node.right = new TreeNode(val);
                    break;
                }
            }
        }
        // Return root
        return root;
    }
}

// T.C => O(h) ------- {h = log (n) for a balanced BST, h = n for a skewed BST}
// S.C => O(1)
