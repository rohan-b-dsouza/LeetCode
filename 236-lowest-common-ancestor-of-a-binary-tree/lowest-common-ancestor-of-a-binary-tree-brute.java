// Brute

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
        // If reached null, return false 
        if (node == null) return false;
        // Add current node to the path
        path.add(node);
        // If node is equal to target return true as path is obtained
        if (node == target) return true;
        // If any path returns true return true
        if (rootToNodePath(node.left, target, path) || rootToNodePath(node.right, target, path))
            return true;
        // Backtrack by removing the last node
        path.remove(path.size() - 1);
        // Return false if path is not obtained
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Lists to store the paths
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        // Get the paths for p and q
    rootToNodePath(root, p, path1);
        rootToNodePath(root, q, path2);
        int i = 0;
        // Traverse over both the paths till both have same nodes, this helps in taking the lowest comment ancestor
        while (i < path1.size() && i < path2.size() && path1.get(i) == path2.get(i)) {
            i++;
        }
        // Return lca
        return path1.get(i - 1);
    }
}

// T.C => O(2 * N) = O(N) in the worst case as we have to find both the paths
// S.C => O(2 * N) = O(N) for the recursive stacks for path1 and path2
