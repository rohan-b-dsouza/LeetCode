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
    public TreeNode getBst(int[] preorder, int upperBound, int[] index) {
        // If index is out of bounds or value at current index is greater than upperBound, return null
        if (index[0] >= preorder.length || preorder[index[0]] > upperBound) return null;
        // Create a node with the current value in the preorder array
        TreeNode root = new TreeNode(preorder[index[0]++]);
        // Recursively call the function to link the left and right subtrees
        root.left =  getBst(preorder, root.val, index);
        root.right = getBst(preorder, upperBound, index);
        // Return the node to link with its parent
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        // Stores index of the preorder array
        int[] index = new int[1];
        // Call the recursive function
        return getBst(preorder, Integer.MAX_VALUE, index);
    }
}

// T.C => O(n)
// S.C => O(h) ----- {h = log(n) for balanced BST and h = n for skewed BST}
