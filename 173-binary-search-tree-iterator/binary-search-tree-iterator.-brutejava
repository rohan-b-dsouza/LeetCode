// Brute

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
    // List to store the inorder traversal
    private List<Integer> inorder;
        // Index to move over the list while next() function is called
        private int index;
    // Get the inorder traversal using Morris Inorder Traversal
        public List<Integer> getInorder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                ans.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode rightMostNode = curr.left;
                while(rightMostNode.right != null && rightMostNode.right != curr) {
                    rightMostNode = rightMostNode.right;
                }
                if (rightMostNode.right == null) {
                    rightMostNode.right = curr;
                    curr = curr.left;
                }
                else {
                    rightMostNode.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
        // Store the inorder traversal in a list and initialize index to 0
        public BSTIterator(TreeNode root) {
           inorder = getInorder(root);
           index = 0;
        }
        public boolean hasNext() {
            // If index is within bounds, return true
            if (index < inorder.size()) {
                return true;
            }
            // Else return false
            return false;
        }
        // Return the element in the list and move the index pointer
        public int next() {    
            return inorder.get(index++);
}}

// T.C => O(n) for the morris traversal, O(1) for the next() and hasNext() function
// S.C => O(n) for the list

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
