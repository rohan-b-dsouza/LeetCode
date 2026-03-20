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
    public TreeNode helper(TreeNode root) {
        if (root == null) return root;
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        if (left == null && right == null) return root;
        else if (left == null) return right;
        else if (right == null) {
            root.right = root.left;
            root.left = null;
            return left;
        }
        // TreeNode rightMost = root.right;
        // root.left.right = root.right;
        left.right = root.right;
        root.right = root.left;
        root.left = null;
        return right;
    }
    public void flatten(TreeNode root) {
        helper(root);
    }
}