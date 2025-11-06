// Optimal (Morris Inorder Traversal)

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
    public List<Integer> inorderTraversal(TreeNode root) {
        // List to store the answer
        List<Integer> ans = new ArrayList<>();
        // Initialize curr to root
        TreeNode curr = root;
        // While curr is not null
        while (curr != null) {
            // If curr's left is null
            if (curr.left == null) {
                // Add curr to ans
                ans.add(curr.val);
                // Move curr to right
                curr = curr.right;
            }
            // If curr has a left node
            else {
                // Get the left node into rightMostNode
                TreeNode rightMostNode = curr.left;
                // Find the rightMostNode in this left subtree
                // While rightMostNode's right is not null and not equal to curr
                while(rightMostNode.right != null && rightMostNode.right != curr) {
                    // Move rightMostNode to right
                    rightMostNode = rightMostNode.right;
                }
                // If rightMostNode's right is null
                if (rightMostNode.right == null) {
                    // Link rightMostNode's right to curr (Threading)
                    rightMostNode.right = curr;
                    // Move curr to left
                    curr = curr.left;
                }
                // If rightMostNode's right is already linked to curr
                else {
                    // Unlink rightMostNode's right to curr
                    rightMostNode.right = null;
                    // Add curr to ans
                    ans.add(curr.val);
                    // Move curr to right
                    curr = curr.right;
                }
            }
        }
        // Return ans
        return ans;
    }
}

// T.C => O(2 * N) = O(N)
// S.C => O(1) 
