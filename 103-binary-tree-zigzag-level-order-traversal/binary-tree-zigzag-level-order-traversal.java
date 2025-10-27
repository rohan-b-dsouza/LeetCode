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
    public void traverseRightToLeft(Deque<TreeNode> queue, List<List<Integer>> ans) {
        int size = queue.size();
        List<Integer> level = new ArrayList<>();
        for (int i = 0; i < size; i++) {
          TreeNode node = queue.pollFirst();
          if (node.right != null) queue.offerLast(node.right);
          if (node.left != null) queue.offerLast(node.left);
          level.add(node.val);
        }
        ans.add(level);
    }
  public void traverseLeftToRight(Deque<TreeNode> queue, List<List<Integer>> ans) {
    int size = queue.size();
    List<Integer> level = new ArrayList<>();
    for (int i = 0; i < size; i++) {
          TreeNode node = queue.pollLast();
          if (node.left != null) queue.offerFirst(node.left);
          if (node.right != null) queue.offerFirst(node.right);
          level.add(node.val);
        }
        ans.add(level);
  }
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) return ans;
    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    boolean flag = true;
    while (!queue.isEmpty()) {
      if (flag) {
        traverseLeftToRight(queue, ans);
        flag = !flag;
      } else {
        traverseRightToLeft(queue, ans);
        flag = !flag;
      }
    }
    return ans;
  }
}