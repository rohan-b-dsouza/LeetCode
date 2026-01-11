// Optimal

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

// Logic:- First compute total Sum of the tree. Now, for each subtree compute the sum & multiply it with (totalSum - sum) ----- {Sum of rest of the tree = totalSum - sum}
// Maintain a maxProd variable and update it at each step. Finally, return the maximum product

class Solution {
    public int getSumOfBT(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = queue.poll();
            sum += node.val;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return sum;
    }

    public int getMaxProd(TreeNode root, long[] maxProd, int totalSum) {
        if (root == null)
            return 0;
        int leftSum = getMaxProd(root.left, maxProd, totalSum);
        int rightSum = getMaxProd(root.right, maxProd, totalSum);
        int sum = leftSum + rightSum + root.val;
        maxProd[0] = Math.max(maxProd[0], sum * 1L * (totalSum - sum));
        return sum;
    }

    public int maxProduct(TreeNode root) {
        int MOD = 1000000007;
        long[] maxProd = new long[1];
        int totalSum = getSumOfBT(root);
        getMaxProd(root, maxProd, totalSum);
        return (int) (maxProd[0] % MOD);
    }
}

// T.C => O(n) + O(n) = O(2 * n) = O(n)
// S.C => O(h) for recursion stack + O(w) for the queue ------- {h = n for skewed tree, h = log (n) for balanced tree} , {w = n when all nodes at last level are filled}
