// Optimal

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

// IMPORTANT NOTE :- In online judges, Pair is an inbuilt class storing a {key:value} pair and having functions getKey() & getValue() 
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        // Queue which stores the pair <TreeNode, Integer>
        Deque<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        // Put the <root, 0> pair to the queue
        queue.offer(new Pair<>(root, 0));
        int ans = 0;
        // While queue is empty
        while (!queue.isEmpty()) {
            // Get the size of the queue
            int size = queue.size();
            // Get the current level's minimum index 
            int min = queue.peek().getValue();
            int first = 0;
            int last = 0;
            // Iterate upto size
            for (int i = 0; i < size; i++) {
                // Get the current node's index and subtract min index from it to normalize for avoiding integer overflow in skewed trees
                int curr = queue.peek().getValue() - min;
                // Get the current node
                TreeNode node = queue.poll().getKey();
                // If this is the first node of the level store the first index
                if (i == 0) first = curr;
                // If this is the last node of the level store the last index
                if (i == size - 1) last = curr;
                // If left node exists, add the left node along with its index into the queue
                if (node.left != null) queue.offer(new Pair<>(node.left, 2 * curr + 1));
                // If right node exists, add the right node along with its index into the queue
                if (node.right != null) queue.offer(new Pair<>(node.right, 2 * curr + 2));
            }
            // Update the maximum width seen so far
            ans = Math.max(ans, last - first + 1);
    }
    // Return ans
    return ans;
    }
}

// T.C => O(N) as we visit each node once
// S.C => O(N) for the queue (Worst Case :- All nodes are present in last level i.e N / 2 nodes)
