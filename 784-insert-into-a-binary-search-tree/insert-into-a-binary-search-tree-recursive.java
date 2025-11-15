// Recursive

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
    public TreeNode insertNode(TreeNode node, int val) {
        // If node is null, create a node with the target value and return it
        if (node == null) return new TreeNode(val);
        // If val is smaller than current node's val recursively move left
        if (val < node.val) node.left = insertNode(node.left, val);
        // Else move right
        else if (val > node.val) node.right = insertNode(node.right, val);
        // Return node
        return node;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insertNode(root, val);
    }
}

// T.C => O(h) ---------- {h = log (n) for a balanced BST, h = n for a skewed BST}
// S.C => O(h) ---------- {h = log (n) for a balanced BST, h = n for a skewed BST}
