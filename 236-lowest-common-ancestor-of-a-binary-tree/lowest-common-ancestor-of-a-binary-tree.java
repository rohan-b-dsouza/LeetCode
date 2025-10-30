/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean rootToNodePath(TreeNode node, TreeNode target, List<TreeNode> path) {
         if (node == null) return false;
        path.add(node);
        if (node == target) return true;
        if (rootToNodePath(node.left, target, path) || rootToNodePath(node.right, target, path))
            return true;
        path.remove(path.size() - 1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
    rootToNodePath(root, p, path1);
        rootToNodePath(root, q, path2);
        int i = 0;
        while (i < path1.size() && i < path2.size() && path1.get(i) == path2.get(i)) {
            i++;
        }
        return path1.get(i - 1);
    }
}