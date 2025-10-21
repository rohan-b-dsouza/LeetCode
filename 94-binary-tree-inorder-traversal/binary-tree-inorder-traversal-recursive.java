// Recursive

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
    public void recursiveInorder(TreeNode node, List<Integer> ans) {
        // If node is null, return 
        if (node == null) return;
        // Recursively go left
        recursiveInorder(node.left, ans);
        // Add the node to the ans
        ans.add(node.val);
        // Recursively go right
        recursiveInorder(node.right, ans);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        // List to store the answer
        List<Integer> ans = new ArrayList<>();
        // Call the recursive function
        recursiveInorder(root, ans);
        // Return the ans
        return ans;
    }
}

// S.C => O(n) as we visit each node once
// S.C => O(n) for skewed B.T and O(log(n)) for balanced BT
