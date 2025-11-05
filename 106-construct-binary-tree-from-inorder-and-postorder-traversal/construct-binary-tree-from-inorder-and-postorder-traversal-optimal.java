// Optimal

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
    public void inorderToIndexMapping(int[] inorder, HashMap<Integer, Integer> inorderToIndexMap) {
        for (int i = 0; i < inorder.length; i++) {
            inorderToIndexMap.put(inorder[i], i);
        }
    }
    public TreeNode buildBinaryTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inorderToIndexMap)  {
        if (postStart > postEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootInorderIndex = inorderToIndexMap.get(root.val);
        int noOfNodesOnLeft = rootInorderIndex - inStart;
        root.left = buildBinaryTree(postorder, postStart, postStart + noOfNodesOnLeft - 1, inorder, inStart, rootInorderIndex - 1, inorderToIndexMap);
        root.right = buildBinaryTree(postorder, postStart + noOfNodesOnLeft, postEnd - 1, inorder, rootInorderIndex + 1, inEnd, inorderToIndexMap);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        HashMap<Integer, Integer> inorderToIndexMap = new HashMap<>();
        inorderToIndexMapping(inorder, inorderToIndexMap);
        return buildBinaryTree(postorder, 0, n - 1, inorder, 0, n - 1, inorderToIndexMap);
    }
}
