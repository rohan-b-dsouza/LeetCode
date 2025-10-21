// Iterative

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
    public List<Integer> postorderTraversal(TreeNode root) {
        // If tree is empty, return empty list
        if (root == null) return new ArrayList<>();
        // List to store the answer
        List<Integer> ans = new ArrayList<>();
        // Stack to backtrack to previous nodes
        Deque<TreeNode> st = new ArrayDeque<>();
        // Push root node to the stack
        st.push(root);
        // Logic for Node - Right - Left, Reversing final output gives Left - Right - Node
        while(!st.isEmpty()) {
            // Get the stack's top node 
            root = st.pop();
            // Add it to the answer
            ans.add(root.val);
            // If left node exists push it to the stack
            if (root.left != null) st.push(root.left);
            // If right node exists push it to the stack
            if (root.right != null) st.push(root.right);
        }
        // Reverse the ans to get the Postorder Traversal
        Collections.reverse(ans);
        // Return the answer
        return ans;
    }
}

// T.C => O(2 * n) = O(n)
// S.C => O(n) for skewed B.T and O(log (n)) for balanced B.T
