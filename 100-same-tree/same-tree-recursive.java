// Recursive (Preorder Traversal)

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If either of the two nodes at any step is null then check if whether both are null or not. If both are null then return true but if one of them is null then they are not identical hence return false
        if (p == null || q == null) return p == q;
        // If nodes are not equal, return false
        if (p.val != q.val) return false;
        // Preorder traversal
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

// T.C => O(n) as we visit all nodes in the worst case i.e both trees are identical
// S.C => O(n) in worst case (skewed B.T) or O(log (n)) for balanced tree 
