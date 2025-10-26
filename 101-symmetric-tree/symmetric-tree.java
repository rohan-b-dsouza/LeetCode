// Optimal (Preorder)

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
        // If both left tree and right tree mirror nodes are null, return true else false
        if (leftTree == null || rightTree == null)
            return leftTree == rightTree;
        // If both left tree and right tree have same data, return true else false
        if (leftTree.val != rightTree.val)
            return false;
        // Do NLR on left tree and NRL on right tree simultaneously
        return checkSymmetry(leftTree.left, rightTree.right) && checkSymmetry(leftTree.right, rightTree.left);
    }
    
    public boolean isSymmetric(TreeNode root) {
        // If tree is empty, return true
        // Else check whether tree is symmetric or not
        return ((root == null) || checkSymmetry(root.left, root.right));
    }
}

// T.C => O(n) since we visit all the nodes once
// S.C => O(n) for skewed B.T and O(log (n)) for balanced B.T
