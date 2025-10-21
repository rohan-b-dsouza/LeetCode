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
    public void recursivePostorder(TreeNode node, List<Integer> ans) {
    // If node is null, return    
    if (node == null) return;
        // Recursively traverse left
        recursivePostorder(node.left, ans);
        // Recursively traverse right
        recursivePostorder(node.right, ans);
        // Add current node to 'ans'
        ans.add(node.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        // List to store the answer
        List<Integer> ans = new ArrayList<>();
        // Call the recursive function
        recursivePostorder(root, ans);
        return ans;
    }
}

// T.C => O(n) as we visit all the nodes
// S.C => O(n) for skewed B.T and O(log (n)) for balanced B.T
