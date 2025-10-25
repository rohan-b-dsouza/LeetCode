// Optimal (Postorder)

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
    public int pathSum(TreeNode node, int[] maxPathSum) {
        // If node is null, return 0
        if (node == null) return 0;
        // Get the left and right max available path sums
        int leftMaxPath = Math.max(0, pathSum(node.left, maxPathSum));
        int rightMaxPath = Math.max(0, pathSum(node.right, maxPathSum));
        // Compute the path sum for current node and update maxPathSum
        maxPathSum[0] = Math.max(maxPathSum[0], node.val + leftMaxPath + rightMaxPath);
        // Return the max path sum to the previous nodes (backtracking)
        return node.val + Math.max(leftMaxPath, rightMaxPath); 
    }
    public int maxPathSum(TreeNode root) {
        // Array of size 1 to track the max path sum
        int[] maxPathSum = new int[1];
        // Set max path sum to smallest integer value initially to ensure that we cover the edge case where the max path sum itself is negative
        maxPathSum[0] = Integer.MIN_VALUE;
        // Call the recursive pathSum function
        pathSum(root, maxPathSum);
        // Return max path sum
        return maxPathSum[0];
    }
}

// T.C => O(n) as we visit all the nodes
// S.C => O(n) for skewed B.T and O(log (n)) for balanced B.T
