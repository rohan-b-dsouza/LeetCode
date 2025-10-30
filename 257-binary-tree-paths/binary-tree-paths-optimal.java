// Optimal (DFS - Inorder Traversal)

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
        // If this is a leaf node, add it to the path and add the path to ans, and return
        if (node.left == null && node.right == null) {
            ans.add(path + node.val);
            return;
        }
        // If left node is present, recursively move left by sending path along with current node's value and an arrow
        if (node.left != null) getAllPaths(node.left, ans, path + node.val + "->");
        // If right node is present, recursively move right by sending path by concatenating current node's value and an arrow  
        if (node.right != null) getAllPaths(node.right, ans, path + node.val + "->");
    }
    public List<String> binaryTreePaths(TreeNode root) {
        // List to store the answer
        List<String> ans = new ArrayList<>();
        // If tree is empty, return an empty list
        if (root == null) return ans;
        // Call the recursive function
        getAllPaths(root, ans, "");
        // Return ans
        return ans;
    }
}

// T.C => O(n * h)
//   - Each node visited once.
//   - Each string concatenation costs O(h).
//   - Balanced tree: O(n log n)
//   - Skewed tree: O(n^2)

// S.C => O(h^2)
//   - Due to recursion + temporary strings at each depth.
//   - Worst case (skewed tree): h = n → O(n^2)
//   - Best case (balanced tree): h = log n → O((log n)^2)
