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
  private TreeNode first = null, middle = null, last = null, prev = null;
  public void getIncorrectNodes(TreeNode root) {
    TreeNode curr = root;
    while (curr != null) {
      if (curr.left == null) {
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
    getIncorrectNodes(root);
    if (first == null) return root;
    if (last != null) {
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
    else {
        int temp = first.val;
        first.val = middle.val;
        middle.val = temp;
    }
    return root;
  }
}