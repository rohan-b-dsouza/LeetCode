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
    // Function to map inorder traversals elements to their corresponding indices
    public void inorderToIndexMapping(int[] inorder, HashMap<Integer, Integer> inorderToIndexMap) {
        for (int i = 0; i < inorder.length; i++) {
            inorderToIndexMap.put(inorder[i], i);
        }
    }
    // Function to build the binary tree
    public TreeNode buildBinaryTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inorderToIndexMap)  {
        // If preStart > preEnd or inStart > inEnd it means we have reached null hence return null
        if (preStart > preEnd || inStart > inEnd) return null;
        // Get the current subtree's root from the preorder traversal array
        TreeNode root = new TreeNode(preorder[preStart]);
        // Get the index of this root in inorder traversal array
        int rootInorderIndex = inorderToIndexMap.get(root.val);
        // Compute no. of nodes present on left of this root in inStart
        int noOfNodesOnLeft = rootInorderIndex - inStart;
        // Recursively build the left subtree
        root.left = buildBinaryTree(preorder, preStart + 1, preStart + noOfNodesOnLeft, inorder, inStart, rootInorderIndex - 1, inorderToIndexMap);
        // Recursively build the right subtree
        root.right = buildBinaryTree(preorder, preStart + noOfNodesOnLeft + 1, preEnd, inorder, rootInorderIndex + 1, inEnd, inorderToIndexMap);
        // Return the root
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // HashMap to store the pair <inorder array's elements, index>
        HashMap<Integer, Integer> inorderToIndexMap = new HashMap<>();
        // Map the pair <inorder, index> 
        inorderToIndexMapping(inorder, inorderToIndexMap);
        // Call the recursive function to build the binary tree
        return buildBinaryTree(preorder, 0, n - 1, inorder, 0, n - 1, inorderToIndexMap);
    }
}

// T.C => O(N) + O(N) = O(2 * N) = O(N)
// S.C => O(N) + O(H) = O(N + H) = O(2 * N) = O(N) ---------{as in worst case i.e skewed B.T, H = N whereas in best case i.e balanced B.T, H = log (N)}
