// Brute (We use the fact that inorder traversal of a BST is in sorted order)

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
    // Get the inorder traversal of the BST
    public void inorder(TreeNode root, List<Integer> tree) {
        if (root == null) return;
        inorder(root.left, tree);
        tree.add(root.val);
        inorder(root.right, tree);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> tree = new ArrayList<>();
        inorder(root, tree);
        // Return the kth element int the inorder traversal
        return tree.get(k - 1);
    }
}

// T.C => O(n)
// S.C => O(n) + O(n) = O(2 * n) = O(n)
