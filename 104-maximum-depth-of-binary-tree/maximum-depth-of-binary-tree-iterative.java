// Iterative  (Level Order Traversal)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    public int maxDepth(TreeNode root) {
        // If tree is empty, return 0
        if (root == null) return 0;
        int cnt = 0; // Counter for tracking the no. of levels (i.e depth of the tree)
        Deque<TreeNode> queue = new ArrayDeque<>(); // Queue for performing level order traversal
        queue.offer(root); // Add root node to the queue
      // While queue is not empty
        while (!queue.isEmpty()) {
          // Get the current size of the queue
            int size = queue.size();
          // Iterate till this size
            for (int i = 0; i < size; i++) {
              // Get the front node
                TreeNode node = queue.poll();
              // If it has a left and right node add them to the queue's back
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }   
          // Increment the level counter
            cnt++;
        }
      // Return cnt
        return cnt;
    }
}

// T.C => O(n) as we visit all the nodes
// S.C => O(n / 2) = O(n) => as in the worst case all leaf nodes will be present (i.e last level will be complete)
