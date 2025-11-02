// Optimal

/**
 * Definition for a binary tree node. public class TreeNode { int data; TreeNode left; TreeNode
 * right; TreeNode(int val) { data = val; left = null, right = null } }
 */
class Solution {
  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    // List to store the answer
    List<Integer> ans = new ArrayList<>();
    // If tree is empty, return empty list
    if (root == null) return ans;
    // HashMap stores the <Node, Parent> pair 
    HashMap<TreeNode, TreeNode> childParentPair = new HashMap<>();
    // Queue to handle <Node, Parent> mapping
    Deque<TreeNode> queue = new ArrayDeque<>();
    // Put the root node to the queue
    queue.offer(root);
    // While queue is not empty
    while (!queue.isEmpty()) {
      // Get the front node
      TreeNode node = queue.poll();
      // If it has a left child
      if (node.left != null) {
        // Add this <child, parent> pair to the map
        childParentPair.put(node.left, node);
        // Add left node to the queue
        queue.offer(node.left);
      }
      // If it has a right child
      if (node.right != null) {
        // Add this <child, parent> pair to the node
        childParentPair.put(node.right, node);
        // Add right node to the queue
        queue.offer(node.right);
      }
    }
    // HashSet to store the visited nodes
    HashSet<TreeNode> visited = new HashSet<>();
    // Add the target node to the queue
    queue.offer(target);
    // Add it to the visited list
    visited.add(target);
    // Initialize current distance to 0
    int currDistance = 0;
    // While queue is not empty
    while (!queue.isEmpty()) {
      // If current distance equals k
      if (currDistance == k) {
        // While queue is not empty, pop all elements from the queue adding it into the ans list
        while (!queue.isEmpty()) {
          ans.add(queue.poll().val);
        }
        // Return ans
        return ans;
      }
      // Get the size of the queue
      int size = queue.size();
      // Iterate over size
      for (int i = 0; i < size; i++) {
        // Get the front node
        TreeNode node = queue.poll();
        // If it has a left child and it's not visited yet
        if ((node.left != null) && (!visited.contains(node.left))) {
          // Add it to the queue and the visited list
          queue.offer(node.left);
          visited.add(node.left);
        }
        // If it has a right child and it's not visited yet 
        if ((node.right != null) && (!visited.contains(node.right))) {
          // Add it the queue and the visited list
          queue.offer(node.right);
          visited.add(node.right);
        }
        // If it has a parent node, and its not visited
        if ((childParentPair.containsKey(node)) && (!visited.contains(childParentPair.get(node)))) {
          // Add it to the queue and the visited list
          queue.offer(childParentPair.get(node));
          visited.add(childParentPair.get(node));
        }
      }
      // Increment current distance
      currDistance++;
    }
    // Return ans
    return ans;
  }
}

// T.C => O(2 * N) = O(N) 
// S.C => O(3 * N) = O(N) 
