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
    public void rightSideView(TreeNode node, int level, List<Integer> ans) {
        if (node == null) return;
        if (ans.size() == level) {
            ans.add(node.val);
        }
        rightSideView(node.right, level + 1, ans);
        rightSideView(node.left, level + 1, ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightSideView(root, 0, ans);
        return ans;
    }
}