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
    public void recursiveInorder(TreeNode node, int row, int col,
            TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (node == null)
            return;
        recursiveInorder(node.left, row + 1, col - 1, map);

        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, new PriorityQueue<>());
        map.get(col).get(row).offer(node.val);
        recursiveInorder(node.right, row + 1, col + 1, map);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        recursiveInorder(root, 0, 0, map);
        for (var colEntry : map.entrySet()) {
            List<Integer> column = new ArrayList<>();
            for (var rowEntry : colEntry.getValue().entrySet()) {
                var pq = rowEntry.getValue();
                while (!pq.isEmpty()) {
                    column.add(pq.poll());
                }
            }
            ans.add(column);
        }
        return ans;
    }
}