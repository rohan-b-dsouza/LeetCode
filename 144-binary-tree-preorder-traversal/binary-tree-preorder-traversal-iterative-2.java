// Iterative - 2

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
        // If tree is empty, return empty list
        if (root == null) return new ArrayList<>();
        // List to store the answer
        List<Integer> ans = new ArrayList<>();
        // Stack for backtracking to previous nodes
        Deque<TreeNode> st = new ArrayDeque<>();
        // Push root node to the stack
        st.push(root);
        // While stack is not empty
        while(!st.isEmpty()) {
            // Get node at stack's top
            root = st.pop();
            // Add it to the ans list
            ans.add(root.val);
            // If right is not null then push to stack
            if (root.right != null) st.push(root.right);
            // If left is not null then push to stack
            if (root.left != null) st.push(root.left);
            // Since stac is a LIFO D.S we first push right then left, so that we can first pop left and then right as this is preorder traversal (i.e NLR)
        }
        // Return ans
        return ans;
    }
}
