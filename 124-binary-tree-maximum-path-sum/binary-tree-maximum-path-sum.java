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
        if (node == null) return 0;
        int leftMaxPath = Math.max(0, pathSum(node.left, maxPathSum));
        int rightMaxPath = Math.max(0, pathSum(node.right, maxPathSum));
        maxPathSum[0] = Math.max(maxPathSum[0], node.val + leftMaxPath + rightMaxPath);
        return node.val + Math.max(leftMaxPath, rightMaxPath); 
    }
    public int maxPathSum(TreeNode root) {
        int[] maxPathSum = new int[1];
        maxPathSum[0] = Integer.MIN_VALUE;
        pathSum(root, maxPathSum);
        return maxPathSum[0];
    }
}