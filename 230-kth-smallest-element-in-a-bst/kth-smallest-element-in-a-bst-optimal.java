// Optimal (We simply use the fact that inorder traversal of a BST is in sorted order)
// For the problem Kth Greatest element in a bst, refer end of this page

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
    // Call Morris Inorder Traversal function and get the kth node
    public int getInorder(TreeNode root, int k) {
        int cnt = 0;
        TreeNode curr = root;
        int ans = -1;
        while (curr != null) {
            if (curr.left == null) {
                cnt++;
                if (cnt == k) ans = curr.val;
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
                    cnt++;
                    if (cnt == k) ans = curr.val;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
    public int kthSmallest(TreeNode root, int k) {
        // Return the kth node
       return getInorder(root, k);
    }
}

// T.C => O(n) 
// S.C => O(1)

// Kth greatest element in a bst

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int val) { data = val; left = null, right = null }
 * }
 **/

class Solution {
    public int getInorder(TreeNode root, int k, int[] cnt) {
        cnt[0] = 0;
        TreeNode curr = root;
        int ans = -1;
        while (curr != null) {
            if (curr.left == null) {
                cnt[0]++;
                if (cnt[0] == k) ans = curr.data;
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
                    cnt[0]++;
                    if (cnt[0] == k) ans = curr.data;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
    public List<Integer> kLargesSmall(TreeNode root, int k) {
       List<Integer> ans = new ArrayList<>();
       int cnt[] = new int[1];
       ans.add(getInorder(root, k, cnt));
       ans.add(getInorder(root, cnt[0] - k + 1, cnt));
    return ans;
    }
}
