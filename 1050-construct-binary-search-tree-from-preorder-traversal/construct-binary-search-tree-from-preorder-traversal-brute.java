// Brute

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
    // Function that inserts node at correct position in the BST
    public TreeNode insertNode(TreeNode node, int val) {
        if (node == null) return new TreeNode(val);
        if (val < node.val) node.left = insertNode(node.left, val);
        else if (val > node.val) node.right = insertNode(node.right, val);
        return node;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        // For each node in the preorder traversal, call the insert function
        for (int i = 1; i < n; i++) {
            insertNode(root, preorder[i]);
        }
        return root;
    }
}

// T.C => O(n * h) ----------- {h = log (n) for balanced BST, h = n for skewed BST}
// S.C => O(1)
