// Recursive

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
    public void recursivePreorder(TreeNode node, List<Integer> ans) {
        if (node == null) return;
        ans.add(node.val);
        recursivePreorder(node.left, ans);
        recursivePreorder(node.right, ans);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recursivePreorder(root, ans);
        return ans;
    }
}

// T.C => O(n)
// S.C => O(n) for skewed B.T and O(log (n)) for balanced B.T
