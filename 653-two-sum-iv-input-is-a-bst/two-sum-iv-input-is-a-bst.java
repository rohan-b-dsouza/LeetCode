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
  private Deque<TreeNode> stack; 
  private boolean reverse;
  public void pushAll(TreeNode root) {
    while (root != null) {
      stack.push(root);
      root = (!reverse) ? root.left : root.right;
    }
  }
  public BSTIterator(TreeNode root, boolean reverse) {
    stack = new ArrayDeque<>();
    this.reverse = reverse;
    pushAll(root);
  }
  public int nextOrBefore() {
    TreeNode temp = stack.pop();
    if (!reverse) pushAll(temp.right);
    else pushAll(temp.left);
    return temp.val;
  }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        // Initialize two objects of the BSTIterator class, 
    // false indicates ascending order and true indicates descending order
    BSTIterator l = new BSTIterator(root, false);
    BSTIterator r = new BSTIterator(root, true);
    int i = l.nextOrBefore();
    int j = r.nextOrBefore();
    while (i < j) {
        if ((i + j) == k) return true;
        else if ((i + j) < k) i = l.nextOrBefore();
        else j = r.nextOrBefore(); 
    }
    return false;
    }
}