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
    public void getPath(TreeNode root, int target, List<TreeNode> path) {
        // While root's val is not equal to target
        while (root.val != target) {
            // Add root to the path
            path.add(root);
            // If target value is on left, move left or move right
            root = (target < root.val) ? root.left : root.right;
        }
        // Return the path by adding the target node
        path.add(root);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Store the path for p and q in a list
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        // Get the paths
        getPath(root, p.val, path1);
        getPath(root, q.val, path2);
        // Set i to 0
        int i = 0;
        // Traverse over both the lists till they the corresponding node is common
        while (i < path1.size() && i < path2.size() && path1.get(i) == path2.get(i)) {
            i++;
        }
        // Return the lca
        return path1.get(i - 1);
    }
}

// T.C => O(h) + O(h) = O(2 * h) = O(h) ---------- {h = log (n) for balanced BST, h = n for skewed BST}
// S.C => O(2 * h) = O(h) ----------------------- {h = log (n) for balanced BST, h = n for skewed BST} 
