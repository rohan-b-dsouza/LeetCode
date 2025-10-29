// Optimal (BFS - Level Order Traversal)

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
    public List<Integer> rightSideView(TreeNode root) {
        // List to store the answer
        List<Integer> ans = new ArrayList<>();
        // If tree is empty, return empty list
        if (root == null) return ans;
        // Deque for level order traversal
        Deque<TreeNode> queue = new ArrayDeque<>();
        // Put the root node into the queue
        queue.offer(root);
        // While queue is not empty
        while (!queue.isEmpty()) {
            // Get the size of the queue
            int size = queue.size();
            // The node at the back of the queue is the rightmost node in the current level, hence add it to ans
            ans.add(queue.peekLast().val);
            // Iterate upto size
            for (int i = 0; i < size; i++) {
                // Pop the node at the front of the queue
                TreeNode node = queue.poll();
                // If it has a left node add it to the queue
                if (node.left != null) queue.offer(node.left);
                // If it has a right node add it to the queue
                if (node.right != null) queue.offer(node.right);
            }   
        }
        // Return ans
        return ans;
    }
}

// T.C => O(N) as we visit each node once
// S.C => O(N) in the worst case i.e when last level has all nodes present i.e N / 2 nodes
