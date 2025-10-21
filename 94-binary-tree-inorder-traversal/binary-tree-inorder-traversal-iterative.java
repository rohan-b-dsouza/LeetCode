// Iterative

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
    public List<Integer> inorderTraversal(TreeNode root) {
        // Stack to handle backtracking
        Deque<TreeNode> st = new ArrayDeque<>();
      // List to store the answer  
      List<Integer> ans = new ArrayList<>();
      // Keep looping until stack is empty and root is also null, this condition denotes that all nodes are traversed
      while (!st.isEmpty() || root != null) { 
          // If root is not null
            if (root != null) {
                // Push current node to the stack
                st.push(root);
              // Traverse left
                root = root.left;
            }
              // If root becomes null
            else {
                // Backtrack to the previous node
                TreeNode node = st.pop();
                // Add its value to the 'ans' list
                ans.add(node.val);
               // Traverse right
                root = node.right;
            }
        }
      // Return ans
        return ans; 
    }
}

// T.C => O(n)
// S.C => O(n) for the stack if its a skewed tree and O(log (n)) for a balanced tree -------{Space reqd for ans list is for output, hence ignored here}
