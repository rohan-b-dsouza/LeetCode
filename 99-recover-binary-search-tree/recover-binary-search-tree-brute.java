// Brute

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
    // Morris Inorder Traversal to get the inorder traversal
    public List<Integer> getInorder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                ans.add(curr.val);
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
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
    // Morris Traversal to replace the actual tree's node values with the sorted inorder of this tree
    public void restoreTree(TreeNode root, List<Integer> inorder) {
        int index = 0;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                curr.val = inorder.get(index++);
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
                    curr.val = inorder.get(index++);
                    curr = curr.right;
                }
            }
        }
    }
    public TreeNode recoverTree(TreeNode root) {
        // Get the inorder traversal
        List<Integer> inorder = getInorder(root);
        // Sort it to get the correct node sequence as we need to swap 2 incorrect node placments
        inorder.sort(null);
        // Now while doing inorder traversal on the tree, replace the node's values with this sorted inorder values
        restoreTree(root, inorder);
        // Return root
        return root;
    }
}

// T.C => O(n) + O(n) + O(n * log (n)) = O(2 * n) + O(n * log (n)) = O(n * log (n)) 
// S.C => O(n) 
