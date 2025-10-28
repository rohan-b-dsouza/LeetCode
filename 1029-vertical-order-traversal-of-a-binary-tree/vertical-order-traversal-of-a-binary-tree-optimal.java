// Optimal (Depth - first traversal (Inorder))
// This problem can be solved using preorder, postorder and level order traversal too. Everything remains same just the traversal differs
 
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
    // Recursive Inorder Traversal Function
    public void recursiveInorder(TreeNode node, int row, int col,
            TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        // If node equals null then return
        if (node == null)
            return;
        // Recursively traverse left by incrementing row and decrementing col
        recursiveInorder(node.left, row + 1, col - 1, map);
        // For current node, check if <col,map> pair is present if not create this pair
        map.putIfAbsent(col, new TreeMap<>());
        // For current <col, map> pair's map doesn't have <row, QriorityQueue> pair then create this pair
        map.get(col).putIfAbsent(row, new PriorityQueue<>());
        // Put the current node's to this map's Priority Queue -> <col, <row, PQ>>
        map.get(col).get(row).offer(node.val);
        // Recursively traverse right
        recursiveInorder(node.right, row + 1, col + 1, map);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Create a map which stores the pair <Col, <Row, Priority Queue of Nodes>>
        // We use Outer TreeMap to ensure the map gives us sorted columns, we use an inner map to ensure map gives us rows also in sorted order
        // Priority queue helps us in retreiving node values in sorted order when multiple nodes belong to the same row and col
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        // List to store the answer
        List<List<Integer>> ans = new ArrayList<>();
        // Call the recursive function with the row and col value as 0 for the root node
        recursiveInorder(root, 0, 0, map);
        // Get the set of col keys
        for (var colEntry : map.entrySet()) {
            // Column which stores node values of current column
            List<Integer> column = new ArrayList<>();
            // Get the set of row keys
            for (var rowEntry : colEntry.getValue().entrySet()) {
                // Get the priority queue corresponding to this column and row
                var pq = rowEntry.getValue();
                // Iterate over this priority queue by popping values and add it to the column list
                while (!pq.isEmpty()) {
                    column.add(pq.poll());
                }
            }
            // Finally, add this column list to the answer list and Repeat the process for next column
            ans.add(column);
        }
        // Return the ans
        return ans;
    }
}
