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
    public TreeNode buildBinaryTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inorderToIndexMap)  {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootInorderIndex = inorderToIndexMap.get(root.val);
        int noOfNodesOnLeft = rootInorderIndex - inStart;
        root.left = buildBinaryTree(preorder, preStart + 1, preStart + noOfNodesOnLeft, inorder, inStart, rootInorderIndex - 1, inorderToIndexMap);
        root.right = buildBinaryTree(preorder, preStart + noOfNodesOnLeft + 1, preEnd, inorder, rootInorderIndex + 1, inEnd, inorderToIndexMap);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        HashMap<Integer, Integer> inorderToIndexMap = new HashMap<>();
        inorderToIndexMapping(inorder, inorderToIndexMap);
        return buildBinaryTree(preorder, 0, n - 1, inorder, 0, n - 1, inorderToIndexMap);
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);
        return buildTree(preorder, inorder);
    }
}