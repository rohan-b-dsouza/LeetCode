/**
 * Definition for a binary tree node. public class TreeNode { int data; TreeNode left; TreeNode
 * right; TreeNode(int val) { data = val; left = null, right = null } }
 */
class Solution {
  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) return ans;
    HashMap<TreeNode, TreeNode> childParentPair = new HashMap<>();
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node.left != null) {
        childParentPair.put(node.left, node);
        queue.offer(node.left);
      }
      if (node.right != null) {
        childParentPair.put(node.right, node);
        queue.offer(node.right);
      }
    }
    HashSet<TreeNode> visited = new HashSet<>();
    queue.offer(target);
    visited.add(target);
    int currDistance = 0;
    while (!queue.isEmpty()) {
      if (currDistance == k) {
        while (!queue.isEmpty()) {
          ans.add(queue.poll().val);
        }
        return ans;
      }
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
      currDistance++;
    }
    return ans;
  }
}
