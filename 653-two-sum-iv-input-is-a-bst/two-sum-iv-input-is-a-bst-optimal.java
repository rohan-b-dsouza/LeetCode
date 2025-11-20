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
 // Function that provides the next or before element (we use the reverse flag here to tell the function whether we want a greater or smaller element)
// next means next element in ascending order
// before means next element in descending order

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
    // Get the first element in asc and desc order
    int i = l.nextOrBefore();
    int j = r.nextOrBefore();
    // While i and j are not equal
    while (i < j) {
        // If i + j is equal to k, return true
        if ((i + j) == k) return true;
        // Else if i + j is smaller than k, move i to next element in asc order (i.e increase i)
        else if ((i + j) < k) i = l.nextOrBefore();
        // Else if i + j is greater than k, move j to next element in desc order (i.e decrease j) 
        else j = r.nextOrBefore(); 
    }
    // Return false
    return false;
    }
}

// T.C => O(n)
// S.C => O(2 * h) = O(h) ------- {h = log (n) for a balanced BST, h = n for a skewed BST}
