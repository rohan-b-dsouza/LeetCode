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
    public void recursivePreorder(TreeNode node, List<Integer> ans) {
        // If node is not null, return
        if (node == null) return;
        // Add the current node to the list
        ans.add(node.val);
        // Recursively traverse to the left
        recursivePreorder(node.left, ans);
        // Recursively traverse to the right
        recursivePreorder(node.right, ans);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        // List to store the answer
        List<Integer> ans = new ArrayList<>();
        // Call the recursive function
        recursivePreorder(root, ans);
        // Return the answer
        return ans;
    }
}

// T.C => O(n) as we visit every node
// S.C => O(n) for skewed B.T and O(log (n)) for balanced B.T
