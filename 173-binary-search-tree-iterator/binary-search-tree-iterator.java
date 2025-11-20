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
class BSTIterator {

    private Deque<TreeNode> stack = new ArrayDeque<>();
        public void pushAll(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
        public BSTIterator(TreeNode root) {
           pushAll(root);
        }

        public boolean hasNext() {
            if (!stack.isEmpty()) return true;
            return false;
        }

        public int next() {
            TreeNode temp = stack.pop();
            pushAll(temp.right);
            return temp.val;
        }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */