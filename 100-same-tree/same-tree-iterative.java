// Iterative (Level order traversal)

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

// A pair that holds the corresponding nodes of both trees
class Pair {
    TreeNode node1, node2;
    Pair(TreeNode node1, TreeNode node2) {
        this.node1 = node1;
        this.node2 = node2;
    }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If initially either of the two roots is null then check if both are null
        if (p == null || q == null)
            return p == q;
        // Queue which stores pair <node of first tree, node of second tree>
        Deque<Pair> queue = new ArrayDeque<>();
        // Put the node pair in the queue
        queue.offer(new Pair(p, q));
        // While queue is not empty
        while (!queue.isEmpty()) {
            // Get the front pair
            Pair pair = queue.poll();
            // Get the two nodes
            TreeNode node1 = pair.node1;
            TreeNode node2 = pair.node2;
            // If both nodes are null then continue as they are identical and don't have any left or right nodes 
            if (node1 == null && node2 == null)
                continue;
            // If one of them is null or the nodes are not same in terms of data, then return false
            if (node1 == null || node2 == null || node1.val != node2.val)
                return false;
            // Put the left nodes of both the node1 and node2 as a pair to the queue
            queue.offer(new Pair(node1.left, node2.left));
            // Put the right nodes of both the node1 and node2 as a pair to the queue
            queue.offer(new Pair(node1.right, node2.right));
        }
        // Return true if no unidentical pair occured
        return true;
    }
}

// Note :- Here, we didn't use the inner for loop as in level order traversal because here didnt have to print or add nodes in level order groups to a list, etc. Hence, while loop is sufficient to traverse in level order. Its only when we require level order groups 
// that we use inner for loop

// T.C => O(n) as we visit all the nodes
// S.C => O(n / 2) = O(n) as in the worst case last level can have all leaf nodes present ------{Also, more precisely since there are node 'pairs' therefore it's anyways O(2 * (n / 2) = O(n)}
