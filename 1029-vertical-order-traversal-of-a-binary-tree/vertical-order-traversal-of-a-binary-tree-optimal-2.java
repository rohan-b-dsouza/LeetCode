// Optimal - 2 (BFS- Level Order Traversal)

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

// Tuple that stores node and its corresponding row and column together
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
      // Queue that stores the tuples
      Deque<Tuple> queue = new ArrayDeque<>();
      // First add the root node along with its row and col as 0 
      queue.offer(new Tuple(root, 0, 0));
      // While queue is not empty, perform level order traversal
      while(!queue.isEmpty()) {
        // Get the tuple from the front of the queue
        Tuple tuple = queue.poll();
        // Get the row, col, and node
        int row = tuple.row;
        int col = tuple.col;
        TreeNode node = tuple.node;
        // If this <col, TreeMap> pair is not present create it
        map.putIfAbsent(col, new TreeMap<>());
        // If this col doesn't have this <row, PriorityQueue> pair then create it
        map.get(col).putIfAbsent(row, new PriorityQueue<>());
        // Put this node's value at with this row and col
        map.get(col).get(row).offer(node.val);
        // If left node is present, put it into the queue by incrementing row value and decrementing column value
        if (node.left != null) {
          queue.offer(new Tuple(node.left, row + 1, col - 1));
        }
        // If right node is present, put it into the queue by incrementing row value and column value
        if (node.right != null) {
          queue.offer(new Tuple(node.right, row + 1, col + 1));
        }
      }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
      // Create a map which stores the pair <Col, <Row, Priority Queue of Nodes>>
      // We use Outer TreeMap to ensure the map gives us sorted columns, we use an inner map to ensure map gives us rows also in sorted order
      // Priority queue helps us in retreiving node values in sorted order when multiple nodes belong to the same row and col
      TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
      List<List<Integer>> ans = new ArrayList<>();
      // Using level order traversal put all the <row, <col, nodes>> pairs into the map
      levelOrderTraversal(root, map);
      // Gets all the outer map entries
      for (var colEntry : map.entrySet()) {
        // Column to store current column values
        List<Integer> column = new ArrayList<>();
        // Get all the inner map entries
        for (var rowEntry : colEntry.getValue().entrySet()) {
          // Get the inner map's values
          PriorityQueue<Integer> pq = rowEntry.getValue();
          // While PQ is not empty, add each node value of PQ to the column
          while(!pq.isEmpty()) {
            column.add(pq.poll());
          }
        }
        // Add this column to the answer
        ans.add(column);
      }
      // Return ans
      return ans;
    }   
}

// T.C => O(N * log (N))
// S.C => O(N) for TreeMap + O(N) for the queue (As in worst case, last level has N / 2 Nodes) 
