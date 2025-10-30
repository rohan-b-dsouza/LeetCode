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
        int len = path.length(); // stores current length for backtracking
        // Append current node value to the path
        path.append(node.val);

        // If it's a leaf node, add the current path to the answer list
        if (node.left == null && node.right == null) {
            ans.add(path.toString());
        } 
        // Else, 
        else {
            // Append -> to the path
            path.append("->");
            // If left node is present move to the left node
            if (node.left != null) getAllPaths(node.left, ans, path);
            // If right node is present move to the right node
            if (node.right != null) getAllPaths(node.right, ans, path);
        }
        path.setLength(len); // backtrack to previous state
    }

    public List<String> binaryTreePaths(TreeNode root) {
        // List to store the answer
        List<String> ans = new ArrayList<>();
        // If tree is empty, return empty list
        if (root == null) return ans;
        // Call the recursive function
        getAllPaths(root, ans, new StringBuilder());
        // Return ans
        return ans;
    }
}