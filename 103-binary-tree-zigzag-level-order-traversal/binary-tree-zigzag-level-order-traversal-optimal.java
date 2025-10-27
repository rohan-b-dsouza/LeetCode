// Optimal (Level order traversal)

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
    // This function will help in traversing on current level from right to left
    public void traverseRightToLeft(Deque<TreeNode> queue, List<List<Integer>> ans) {
        int size = queue.size();  // Get size of queue
        List<Integer> level = new ArrayList<>(); // Stores the current level
        // Traverse over the queue upto size times
        for (int i = 0; i < size; i++) {
          // Get the front node
          TreeNode node = queue.pollFirst();
            // Put the left and right nodes of this node to the queue from the back
          if (node.right != null) queue.offerLast(node.right);
          if (node.left != null) queue.offerLast(node.left);
         // Add popped node to the level 
         level.add(node.val);
        }
        // Add the level to ans
        ans.add(level);
    }
    // This function will help in traversing on current level from left to right
  public void traverseLeftToRight(Deque<TreeNode> queue, List<List<Integer>> ans) {
    int size = queue.size();
    List<Integer> level = new ArrayList<>();
    for (int i = 0; i < size; i++) {
         // Get the node from the back 
         TreeNode node = queue.pollLast();
        // Put the left and right nodes of this node to the queue from the front
          if (node.left != null) queue.offerFirst(node.left);
          if (node.right != null) queue.offerFirst(node.right);
        // Add popped node to the level
          level.add(node.val);
        }
      // Add the level to ans
        ans.add(level);
  }
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    // List to store the ans
    List<List<Integer>> ans = new ArrayList<>();
    // If tree is empty return empty list
    if (root == null) return ans;
    // Queue for the level order traversal
    Deque<TreeNode> queue = new ArrayDeque<>();
    // Put the root node into the queue
    queue.offer(root);
    // Flag to handle direction of traversal, when its true direction is left -> right, whereas when its false direction is right -> left
    boolean flag = true;
    // While queue is not empty
    while (!queue.isEmpty()) {
      // If flag is true, traverse left to right
      if (flag) {
        traverseLeftToRight(queue, ans);
        // Invert flag for alternate traversal
        flag = !flag;
          // Else 
      } else {
          // Traverse right to left
        traverseRightToLeft(queue, ans);
          // Invert flag for alternate traversal
        flag = !flag;
      }
    }
    // Return ans
    return ans;
  }
}

// T.C => O(n) as we visit each node once
// S.C => O(n) as in the worst case last level can have all nodes present i.e n / 2 nodes approx.
