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
    public boolean checkBST(TreeNode root, long min, long max) {
        // If root is null, return true
        if (root == null) return true;
        // If root's val is smaller than equal to min or greater than equal to max
        if (root.val <= min || root.val >= max) {
            // Return false
            return false;
        }
        // Recursively check the left and right subtree
        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        // Call the recursive function
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}

// T.C => O(n) as we visit each node once
// S.C => O(n) for the recursive stack
