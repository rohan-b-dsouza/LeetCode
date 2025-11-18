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
    public TreeNode getBst(int[] preorder, int upperBound, int[] index) {
        if (index[0] >= preorder.length || preorder[index[0]] > upperBound) return null;
        TreeNode root = new TreeNode(preorder[index[0]++]);
        root.left =  getBst(preorder, root.val, index);
        root.right = getBst(preorder, upperBound, index);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] index = new int[1];
        return getBst(preorder, Integer.MAX_VALUE, index);
    }
}