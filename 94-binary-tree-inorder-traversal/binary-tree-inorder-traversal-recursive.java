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
    public void recursiveInorder(TreeNode node, List<Integer> ans) {
        if (node == null) return;
        recursiveInorder(node.left, ans);
        ans.add(node.val);
        recursiveInorder(node.right, ans);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recursiveInorder(root, ans);
        return ans;
    }
}

// S.C => O(n) as we visit each node once
// S.C => O(n) for skewed B.T and O(log(n)) for balanced BT
