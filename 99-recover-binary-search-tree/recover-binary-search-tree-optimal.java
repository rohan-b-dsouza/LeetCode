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
class Solution {
  // Private Member Variables which can be accessed using functions of the same class (controlled access) (These are not global variables)
  private TreeNode first = null, middle = null, last = null, prev = null;
  // Get the incorrect nodes using inorder traversal
  public void getIncorrectNodes(TreeNode root) {
    // Set curr to root
    TreeNode curr = root;
    // While curr is not null
    while (curr != null) {
      // If curr's left is null
      if (curr.left == null) {
        // If prev is null and curr's val is smaller than prev, voilation occurs
        if (prev != null && curr.val < prev.val) {
          // If first is null, then store prev as first and curr as middle (This is done to handle the case where tree has adjacent incorrect nodes)
          if (first == null) {
            first = prev;
            middle = curr;
          } 
          // Else set last as curr
          else {
            last = curr;
          }
        }
        // Move prev to curr node
        prev = curr;
        // Move curr to right
        curr = curr.right;
      } else {
        TreeNode rightMostNode = curr.left;
        while (rightMostNode.right != null && rightMostNode.right != curr) {
          rightMostNode = rightMostNode.right;
        }
        if (rightMostNode.right == null) {
          rightMostNode.right = curr;
          curr = curr.left;
        } else {
          rightMostNode.right = null;
          // Same as done before
          if (prev != null && curr.val < prev.val) {
            if (first == null) {
              first = prev;
              middle = curr;
            } else {
              last = curr;
            }
          }
          prev = curr;
          curr = curr.right;
        }
      }
    }
  }

  public TreeNode recoverTree(TreeNode root) {
    // Get the two incorrect nodes
    getIncorrectNodes(root);
    // If first is null, return root i.e there are no incorrect nodes
    if (first == null) return root;
    // Case 1 : Incorrect nodes are not adjacent
    if (last != null) {
        // Swap the incorrect nodes
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
    // Case 2 : Incorrect nodes are adjacent
    else {
        int temp = first.val;
        first.val = middle.val;
        middle.val = temp;
    }
    // Return root
    return root;
  }
}

// T.C => O(n)
// S.C => O(1)
