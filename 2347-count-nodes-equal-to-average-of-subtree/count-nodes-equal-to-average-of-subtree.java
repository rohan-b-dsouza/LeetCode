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
class Pair {
    int sum, nodeCnt;
    Pair(int sum, int nodeCnt) {
        this.sum = sum;
        this.nodeCnt = nodeCnt;
    }
}
class Solution {
    public Pair postorder(TreeNode node, int[] ans) {
        if (node == null) {
            return new Pair(0, 0);
        }
        Pair left = postorder(node.left, ans);
        Pair right = postorder(node.right, ans);
        int sum = left.sum + right.sum + node.val;
        int cnt = left.nodeCnt + right.nodeCnt + 1;
        if (sum / cnt == node.val) {
            ans[0] += 1;
        } 
        return new Pair(sum, cnt);
    }
    public int averageOfSubtree(TreeNode root) {
        int[] ans = new int[1];
        postorder(root, ans);
        return ans[0];
    }
}