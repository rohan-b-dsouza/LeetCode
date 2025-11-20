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
    public boolean twoSum(List<Integer> nums, int target) {
    int n = nums.size();
    int i = 0;
    int j = n - 1;
    while (i < j) {
      int sum = nums.get(i) + nums.get(j);
      if (sum == target) return true;
      else if (sum > target) j--;
      else i++;
    }
    return false;
  }
    public List<Integer> getInorder(TreeNode root, List<Integer> ans) {
    TreeNode curr = root;
    while (curr != null) {
      if (curr.left == null) {
        ans.add(curr.val);
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
          ans.add(curr.val);
          curr = curr.right;
        }
      }
    }
    return ans;
  }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        return twoSum(inorder, k);
    }
}