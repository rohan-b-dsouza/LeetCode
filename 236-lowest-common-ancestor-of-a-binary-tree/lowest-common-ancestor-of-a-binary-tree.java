// Optimal (DFS - Preorder Traversal)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If root is null or root matches with either p or q, then return root
        if (root == null || root == p || root == q) return root;
        // Recursively traverse the left subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // Recursively traverse the right subtree
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // If left is null, then return right
        if (left == null) {
            return right;
        }
        // If right is null, then return left
        else if (right == null) {
            return left;
        }
        // If both left and right are not null, it means p and q lie in different subtrees — hence, current node is their LCA
        else return root;
    }
}

// T.C => O(N) as we visit all the nodes
// S.C => O(N) for skewed B.T and O(log (n)) for balanced B.T
