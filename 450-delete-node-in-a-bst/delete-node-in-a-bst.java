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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null;
        TreeNode temp = root;

        // Step 1: Search for the node
        while (temp != null && temp.val != key) {
            parent = temp;
            if (key < temp.val) temp = temp.left;
            else temp = temp.right;
        }

        // Key not found
        if (temp == null) return root;

        // Step 2: Node has two children -> replace with inorder predecessor
        if (temp.left != null && temp.right != null) {
            TreeNode predParent = temp;
            TreeNode leftMax = temp.left;

            // Find rightmost node in left subtree (predecessor)
            while (leftMax.right != null) {
                predParent = leftMax;
                leftMax = leftMax.right;
            }

            // Replace value
            temp.val = leftMax.val;

            // Now delete predecessor instead
            temp = leftMax;
            parent = predParent;
        }

        // Step 3: Node has at most one child
        TreeNode child = (temp.left != null) ? temp.left : temp.right;

        // If deleting root
        if (parent == null) return child;

        // Attach child to its parent
        if (parent.left == temp) parent.left = child;
        else parent.right = child;

        return root;
    }
}