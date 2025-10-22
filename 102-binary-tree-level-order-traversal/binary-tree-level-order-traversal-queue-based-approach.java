// Queue Based Approach (BFS)

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // List to store the answer
        List<List<Integer>> ans = new ArrayList<>();
        // If tree is empty return empty list
        if (root == null) return ans;
        // Queue to manage level order traversal
        Deque<TreeNode> queue = new ArrayDeque<>();
        // Enqueue root node to the queue
        queue.offer(root);
        // While queue is not empty
        while (!queue.isEmpty()) {
            // Create a new list level which stores nodes of current level
            List<Integer> level = new ArrayList<>();
            // Get the size of queue
            int size = queue.size();
            // Iterate till this size
            for (int i = 0; i < size; i++) {
                // Dequeue the node from the queue
                TreeNode node = queue.poll();
                // If it has a left node, enqueue it to the queue
                if (node.left != null) queue.offer(node.left);
                // Sly, If it has a right node, enqueue it to the queue
                if (node.right != null) queue.offer(node.right);
                // Add the dequeued node to the current level order list
                level.add(node.val);
            }   
            // Add current level to the ans
            ans.add(level);
        }
        // Return ans
        return ans;
    }
}

// T.C => O(n)
// S.C => O(n) for the queue i.e in the worst case when all leaf nodes are present ------- {O(n) for the ans list is output space so not counted here}
