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
    public void getAllPaths(TreeNode node, List<String> ans, StringBuilder path) {
    if (node.left == null && node.right == null) {
        ans.add(path.toString() + node.val);
        return;
    }
    int len = path.length();
    path.append(node.val).append("->");
    if (node.left != null) getAllPaths(node.left, ans, path);
    if (node.right != null) getAllPaths(node.right, ans, path);
    path.setLength(len); // backtrack
}

public List<String> binaryTreePaths(TreeNode root) {
    List<String> ans = new ArrayList<>();
    if (root == null) return ans;
    getAllPaths(root, ans, new StringBuilder());
    return ans;
}
}