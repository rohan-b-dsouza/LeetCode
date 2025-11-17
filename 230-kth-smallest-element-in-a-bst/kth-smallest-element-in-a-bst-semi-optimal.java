// Semi - Optimal  (We simply use the fact that inorder traversal of a BST is in sorted order)
// For the Problem Kth Greatest element in a bst refer end of this page
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
    public void inorder(TreeNode root, int k,int[] ans, int[] cnt) {
    // If root is null or we have got the answer, return
    if (root == null || cnt[0] == -1) return;
    // Recursively move left
    inorder(root.left, k, ans, cnt);
    // Increment counter
    cnt[0]++;
    // If counter equals k it means we are at the desired node
    if (cnt[0] == k) {
      // Store the value in ans
      ans[0] = root.val;
      // Set counter to -1 to mark that we have got the answer to ensure early exit from the recursion
      cnt[0] = -1;
      // Return;
      return;
    }
    // Recursively move right
    inorder(root.right, k, ans, cnt);
  }
    public int kthSmallest(TreeNode root, int k) {
        // Arrays to store the counter and ans
        int[] cnt = new int[1];
        int[] ans = new int[1];
        // Call the recursive function
        inorder(root, k, ans, cnt);
        // Return ans
        return ans[0];
    }
}

// T.C => O(n) as we visit all nodes in the worst case 
// S.C => O(h) for the recursive stack --------- {h = log (n) for balanced BST, h = n for skewed BST}


// Kth largest element in a bst

class Solution {
  public void inorder(TreeNode root, int k, List<Integer> ans, int[] cnt) {
    if (root == null) return;
    inorder(root.left, k, ans, cnt);
    cnt[0]++;
    if (cnt[0] == k) {
      ans.add(root.data);
      return;
    }
    inorder(root.right, k, ans, cnt);
  }
  // For getting the kth greatest element apply inorder traversal in reversal manner i.e R-N-L
  public void reverseInorder(TreeNode root, int k, List<Integer> ans, int[] cnt) {
    if (root == null) return;
    reverseInorder(root.right, k, ans, cnt);
    cnt[0]++;
    if (cnt[0] == k) {
        ans.add(root.data);
        return;
    }
    reverseInorder(root.left, k, ans, cnt);
  }

  public List<Integer> kLargesSmall(TreeNode root, int k) {
    int[] cnt = new int[1];
    List<Integer> ans = new ArrayList<>();
    inorder(root, k, ans, cnt);
    cnt[0] = 0;
    reverseInorder(root, k, ans, cnt);
    return ans;
  }
}

