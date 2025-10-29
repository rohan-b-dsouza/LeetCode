// Optimal - Depth First Search (Preorder)

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
    public void rightSideView(TreeNode node, int level, List<Integer> ans) {
        // If node is null, return
        if (node == null) return;
        // If size of ans list is equal to level it means we haven't got the node for this level till now hence take the current node
        if (ans.size() == level) {
            ans.add(node.val);
        }
        // Recursively traverse in the right subtree with incremented level
        rightSideView(node.right, level + 1, ans);
        // Recursively traverse in the left subtree with incremented level
        rightSideView(node.left, level + 1, ans);
    }
    public List<Integer> rightSideView(TreeNode root) {
        // List to store the ans
        List<Integer> ans = new ArrayList<>();
        // Call the recursive function
        rightSideView(root, 0, ans);
        // Return ans
        return ans;
    }
}

// T.C => O(N) as we visit each node once
// S.C => O(N) for a skewed tree and O(log (N)) for a balanced tree
