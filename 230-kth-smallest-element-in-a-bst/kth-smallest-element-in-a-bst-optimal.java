// Optimal (We simply use the fact that inorder traversal of a BST is in sorted order)

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
    // Call Morris Inorder Traversal function and get the kth node
    public int getInorder(TreeNode root, int k) {
        int cnt = 0;
        TreeNode curr = root;
        int ans = -1;
        while (curr != null) {
            if (curr.left == null) {
                cnt++;
                if (cnt == k) ans = curr.val;
                curr = curr.right;
            }
            else {
                TreeNode rightMostNode = curr.left;
                while(rightMostNode.right != null && rightMostNode.right != curr) {
                    rightMostNode = rightMostNode.right;
                }
                if (rightMostNode.right == null) {
                    rightMostNode.right = curr;
                    curr = curr.left;
                }
                else {
                    rightMostNode.right = null;
                    cnt++;
                    if (cnt == k) ans = curr.val;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
    public int kthSmallest(TreeNode root, int k) {
        // Return the kth node
       return getInorder(root, k);
    }
}

// T.C => O(n) 
// S.C => O(1)
