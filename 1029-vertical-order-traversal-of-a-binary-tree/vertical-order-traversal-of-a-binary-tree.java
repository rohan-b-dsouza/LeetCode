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


class Tuple {
  TreeNode node;
  int row;
  int col;
  Tuple(TreeNode node, int row, int col) {
    this.node = node;
    this.row = row;
    this.col = col;
  }
}


    public void levelOrderTraversal(TreeNode root, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
      Deque<Tuple> queue = new ArrayDeque<>();
      queue.offer(new Tuple(root, 0, 0));
      while(!queue.isEmpty()) {
        Tuple tuple = queue.poll();
        int row = tuple.row;
        int col = tuple.col;
        TreeNode node = tuple.node;
        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, new PriorityQueue<>());
        map.get(col).get(row).offer(node.val);
        if (node.left != null) {
          queue.offer(new Tuple(node.left, row + 1, col - 1));
        }
        if (node.right != null) {
          queue.offer(new Tuple(node.right, row + 1, col + 1));
        }
      }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
      TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
      List<List<Integer>> ans = new ArrayList<>();
      levelOrderTraversal(root, map);
      for (var colEntry : map.entrySet()) {
        List<Integer> column = new ArrayList<>();
        for (var rowEntry : colEntry.getValue().entrySet()) {
          PriorityQueue<Integer> pq = rowEntry.getValue();
          while(!pq.isEmpty()) {
            column.add(pq.poll());
          }
        }
        ans.add(column);
      }
      return ans;
    }   
}
