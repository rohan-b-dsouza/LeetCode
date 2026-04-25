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
    public TreeNode buildMaxTree(int l, int r, int[] nums) {
        if (l > r) return null;
        int max = -1;
        int idx = -1;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = buildMaxTree(l, idx - 1, nums);
        node.right =  buildMaxTree(idx + 1, r, nums);
        return node;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int n = nums.length;
        return buildMaxTree(0, n - 1, nums);
    }
}