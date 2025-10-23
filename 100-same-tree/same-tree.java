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

class Pair {
    TreeNode node1, node2;

    Pair(TreeNode node1, TreeNode node2) {
        this.node1 = node1;
        this.node2 = node2;
    }
}

class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;
        Deque<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(p, q));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node1 = pair.node1;
            TreeNode node2 = pair.node2;

            if (node1 == null && node2 == null)
                continue;
            if (node1 == null || node2 == null || node1.val != node2.val)
                return false;
            queue.offer(new Pair(node1.left, node2.left));
            queue.offer(new Pair(node1.right, node2.right));
        }
        return true;
    }
}