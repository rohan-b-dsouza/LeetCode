// Optimal

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
    public TreeNode searchBST(TreeNode root, int val) {
        // Get the root node
        TreeNode node = root;
        // If node is not null and node's val is not equal to target value
        while (node != null && node.val != val) {
            // If target is smaller than current node's val move left else move right
            node = (val < node.val) ? node.left : node.right;
        }
        // Return node
        return node;
    }
}

// T.C => O(h)  [O(log n) for balanced BST, O(n) worst case]
// S.C => O(1)
