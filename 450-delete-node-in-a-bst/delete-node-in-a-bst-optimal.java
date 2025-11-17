// Optimal

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        // Initialize parent to null and curr to root
        TreeNode parent = null;
        TreeNode curr = root;
        // If curr is not null and curr's val is not equal to key
        while (curr != null && curr.val != key) {
            // Set Parent to curr
            parent = curr;
            // If key is smaller than curr, move curr to left 
            if (key < curr.val) curr = curr.left;
            // Else move curr to right
            else curr = curr.right;
        }
        // Case 1: Tree is empty or key was not found, return root
        if (curr == null) return root;
        // Case 2: Key node has either 0 or 1 child
        if (curr.left == null || curr.right == null) {
            // Get the child node of curr node
            TreeNode child = curr.left != null ? curr.left : curr.right;
            // Next line also covers following Case 3 : Tree has only the root node which is also the key, hence return child
            if (parent == null) return child;
            // If parent's left is curr node then link curr's child to parent's left
            if (parent.left == curr) parent.left = child;
            // Else if parent's right is curr node then link curr's child to parent's right
            else parent.right = child;
            // Return the root node
            return root;
        }
        // Case 4: Key node has both left and right child; hence we have to find the predecessor of the key node
        // Set Predecessor's parent to curr and Predecessor as curr's left
        TreeNode preParent = curr;
        TreeNode predecessor = curr.left;
        // While predecessor's right exists move predecessor to right
        while (predecessor.right != null) {
            // Set predecessor's parent to predecessor
            preParent = predecessor;
            // Move predecessor to right
            predecessor = predecessor.right;
        }
        // Now replace curr's val (i.e key node) with predecessor's val
        curr.val = predecessor.val;
        // If preParent's left is predecessor
        if (preParent.left == predecessor) {
            // Set preParent's left as predecessor's left
            preParent.left = predecessor.left;
        }
        // Else if preParent's right is predecessor
        else {
            // Set preParent's right as predecessor's left
            preParent.right = predecessor.left;
        }
        // Return the root node
        return root;
    }
}

// T.C => O(h) --------- {h = log (n) for balanced BST, h = n for skewed BST}
// S.C => O(1) 
