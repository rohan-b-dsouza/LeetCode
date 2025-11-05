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
    // Function to map inorder traversal element's to their corresponding indices
    public void inorderToIndexMapping(int[] inorder, HashMap<Integer, Integer> inorderToIndexMap) {
        // Store the pair <inorder traversal element, index>
        for (int i = 0; i < inorder.length; i++) {
            inorderToIndexMap.put(inorder[i], i);
        }
    }
    // Function to build the binary tree
    public TreeNode buildBinaryTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inorderToIndexMap)  {
        // If postStart is greater than postEnd or inStart is greater than inEnd, it means null is reached hence return null
        if (postStart > postEnd || inStart > inEnd) return null;
        // Get the root of the current subtree
        TreeNode root = new TreeNode(postorder[postEnd]);
        // Get the root's index in the inorder traversal array
        int rootInorderIndex = inorderToIndexMap.get(root.val);
        // Compute the no. of elements in the left subtree
        int noOfNodesOnLeft = rootInorderIndex - inStart;
        // Recursively build the left subtree
        root.left = buildBinaryTree(postorder, postStart, postStart + noOfNodesOnLeft - 1, inorder, inStart, rootInorderIndex - 1, inorderToIndexMap);
        // Recursively build the right subtree
        root.right = buildBinaryTree(postorder, postStart + noOfNodesOnLeft, postEnd - 1, inorder, rootInorderIndex + 1, inEnd, inorderToIndexMap);
        // Return root
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        // HashMap to map the inorder traversal elements to their corresponding indices
        HashMap<Integer, Integer> inorderToIndexMap = new HashMap<>();
        // Call the mapping function
        inorderToIndexMapping(inorder, inorderToIndexMap);
        // Call the recursive function to build the Binary tree
        return buildBinaryTree(postorder, 0, n - 1, inorder, 0, n - 1, inorderToIndexMap);
    }
}

// T.C => O(N) + O(N) = O(2 * N) = O(N)
// S.C => O(N) + O(H) = O(2 * N) = O(N) ---------------- {Worst Case : Skewed Tree -> H = N, Best Case : Balanced B.T -> H = log(N)}
