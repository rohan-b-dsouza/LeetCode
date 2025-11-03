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
    // Function to get height of left subtree
    public int getLeftHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.left;
            height++;
        }
        return height;
    }
    // Function to get height of right subtree
    public int getRightHeight(TreeNode root) {
        int height = 0;
        while (root != null) {
            root = root.right;
            height++;
        }
        return height;
    }
    public int countNodes(TreeNode root) {
        // If root is null return 0
        if (root == null) return 0;
        // Get height of left subtree
        int left = getLeftHeight(root);
        // Get height of right subtree
        int right = getRightHeight(root);
        // If left subtree and right subtree are equal in height, it means it's a complete subtree hence we can directly compute the no. of nodes in this subtree using the formula 2^h - 1 where h = height of the subtree
        if (left == right) return ((1 << left) - 1);
        // If left is not equal to right, then count the current node and move to left node and then right node, recursively accumulating the count of nodes
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

// T.C => O(log(n)) * O(log(n)) = O((log(n))^2)
// S.C => O(log (n)) for recursion stack
