// Optimal (Same as Leetcode Problem : All Nodes Distance K in Binary Tree with with minimal changes)

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
  // Function to map the <Parent, Child> pair and find the startNode
  public TreeNode mapChildParent(
    TreeNode root, HashMap<TreeNode, TreeNode> childParentPair, int start) {
    // Queue to handle BFS
    Deque<TreeNode> queue = new ArrayDeque<>();
    // Put the root node into the queue
    queue.offer(root);
    // Initialize startNode to null, it will store the node with value as start
    TreeNode startNode = null;
    // While queue is not empty
    while (!queue.isEmpty()) {
      // Get the front node
      TreeNode node = queue.poll();
      // If node's value equals start, store it in startNode
      if (node.val == start) startNode = node;
      // If left node exists
      if (node.left != null) {
        // Map the <Child, Parent> pair
        childParentPair.put(node.left, node);
        // Put the left node into the queue
        queue.offer(node.left);
      }
      // If right node exists
      if (node.right != null) {
        // Map the <Child, Parent> pair
        childParentPair.put(node.right, node);
        // Put the right node into the queue
        queue.offer(node.right);
      }
    }
    // Return startNode
    return startNode;
  }
  // Function to determine the amount of time for binary tree to be infected
  public int amountOfTime(TreeNode root, int start) {
    // If tree is empty, return 0
    if (root == null) return 0;
    // HashMap to store the pair <Child, Parent> pair
    HashMap<TreeNode, TreeNode> childParentPair = new HashMap<>();
    // Call the mapChildParent() function to get the startNode
    TreeNode startNode = mapChildParent(root, childParentPair, start);
    // Queue to handle BFS
    Deque<TreeNode> queue = new ArrayDeque<>();
    // HashSet to store the visited nodes
    HashSet<TreeNode> visited = new HashSet<>();
    // Put the startNode to the queue and put it in the visited HashSet
    queue.offer(startNode);
    visited.add(startNode);
    // Initialize current time to 0
    int currTime = 0;
    // While queue is not empty
    while (!queue.isEmpty()) {
      // Get the size of the queue
      int size = queue.size();
      // Iterate till size
      for (int i = 0; i < size; i++) {
        // Get the front node of the queue
        TreeNode node = queue.poll();
        // If left node is present and it's not visited 
        if ((node.left != null) && (!visited.contains(node.left))) {
          // Put it in the queue and visited set
          queue.offer(node.left);
          visited.add(node.left);
        }
        // If right node is present and it's not visited 
        if ((node.right != null) && (!visited.contains(node.right))) {
          // Put it in the queue and visited set
          queue.offer(node.right);
          visited.add(node.right);
        }
        // If parent node is present and it's not visited
        if ((childParentPair.containsKey(node)) && (!visited.contains(childParentPair.get(node)))) {
          // Put it in the queue and visited set
          queue.offer(childParentPair.get(node));
          visited.add(childParentPair.get(node));
        }
      }
      // Increment current time
      currTime++;
    }
    // Return current time - 1 as it counts 1 more (DRY RUN TO UNDERSTAND)
    return currTime - 1;
  }
}

// T.C => O(2 * N) = O(N)
// S.C => O(4 * N) = O(N)
