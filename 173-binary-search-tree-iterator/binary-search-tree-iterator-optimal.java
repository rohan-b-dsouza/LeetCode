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
class BSTIterator {
    // Stack to simulate inorder traversal
    private Deque<TreeNode> stack = new ArrayDeque<>();
        public void pushAll(TreeNode root) {
            // If root is not null, push root and all the left subtree's left elements to simulate inorder traversal
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
        // Push the first left elements in the stack
        public BSTIterator(TreeNode root) {
           pushAll(root);
        }

        public boolean hasNext() {
            // If stack is not empty, return true
            if (!stack.isEmpty()) return true;
            // Return false
            return false;
        }

        public int next() {
            // Get the stack's top
            TreeNode temp = stack.pop();
            // Push all its right subtree's left elements to the stack
            pushAll(temp.right);
            // Return popped element's data
            return temp.val;
        }
}

// T.C => Amortised O(1) for next() and O(1) for hasNext() 
// S.C => O(h) ------- {h = log (n) for balanced BST, h = n for skewed BST}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
