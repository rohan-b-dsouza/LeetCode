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
    public void getAllPaths(TreeNode node, List<String> ans, String path) {
        if (node.left == null && node.right == null) {
            ans.add(path + node.val);
        }
        if (node.left != null) getAllPaths(node.left, ans, path + node.val + "->");
        if (node.right != null) getAllPaths(node.right, ans, path + node.val + "->");
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) return ans;
        getAllPaths(root, ans, "");
        return ans;
    }
}