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
  public TreeNode mapChildParent(
    TreeNode root, HashMap<TreeNode, TreeNode> childParentPair, int start) {
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    TreeNode startNode = null;
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node.val == start) startNode = node;
      if (node.left != null) {
        childParentPair.put(node.left, node);
        queue.offer(node.left);
      }
      if (node.right != null) {
        childParentPair.put(node.right, node);
        queue.offer(node.right);
      }
    }
    return startNode;
  }

  public int amountOfTime(TreeNode root, int start) {
    if (root == null) return 0;
    HashMap<TreeNode, TreeNode> childParentPair = new HashMap<>();
    TreeNode startNode = mapChildParent(root, childParentPair, start);
    Deque<TreeNode> queue = new ArrayDeque<>();
    HashSet<TreeNode> visited = new HashSet<>();
    queue.offer(startNode);
    visited.add(startNode);
    int currTime = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if ((node.left != null) && (!visited.contains(node.left))) {
          queue.offer(node.left);
          visited.add(node.left);
        }
        if ((node.right != null) && (!visited.contains(node.right))) {
          queue.offer(node.right);
          visited.add(node.right);
        }
        if ((childParentPair.containsKey(node)) && (!visited.contains(childParentPair.get(node)))) {
          queue.offer(childParentPair.get(node));
          visited.add(childParentPair.get(node));
        }
      }
      currTime++;
    }
    return currTime - 1;
  }
}