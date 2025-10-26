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
    public boolean checkSymmetry(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null || rightTree == null)
            return leftTree == rightTree;
        if (leftTree.val != rightTree.val)
            return false;
        return checkSymmetry(leftTree.left, rightTree.right) && checkSymmetry(leftTree.right, rightTree.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return ((root == null) || checkSymmetry(root.left, root.right));
    }
}