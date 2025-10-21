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
if (node == null) return;
        recursivePostorder(node.left, ans);
        recursivePostorder(node.right, ans);
        ans.add(node.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recursivePostorder(root, ans);
        return ans;
    }
}