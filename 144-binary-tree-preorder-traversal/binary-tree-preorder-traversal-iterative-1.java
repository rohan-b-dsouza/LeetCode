// Iterative-1

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
    public List<Integer> preorderTraversal(TreeNode root) {
        // List to store the answer
        List<Integer> ans = new ArrayList<>();
        // Stack to backtrack to previous nodes
        Deque<TreeNode> st = new ArrayDeque<>();
        // While stack is not empty or root is not null
        while (!st.isEmpty() || root != null) {
            // If root is not null
            if (root != null) {
                // Add current node to the answer
                ans.add(root.val);
                // Push it to the stack
                st.push(root);
                // Traverse left
                root = root.left;
            }
            // If root is null
            else {
                // Backtrack and Traverse right
                root = st.pop();
                root = root.right;
            }
        }
        return ans;
    }
}

// T.C => O(n) as we visit every node
// S.C => O(n) for skewed B.T and O(log (n)) for balanced B.T
