// Optimal

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Preorder traversal to serialize the binary tree
    public void preorder(TreeNode root, StringBuilder serialized) {
        // If root is null
        if (root == null) {
            // Append # (represents null) and ,
            serialized.append('#').append(',');
            return;
        }
        // Append root's data and ,
        serialized.append(root.val).append(',');
        // Recursively go left
        preorder(root.left, serialized);
        // Recursively go right
        preorder(root.right, serialized);
    }
    // Function which encodes the tree to a single string
    public String serialize(TreeNode root) {
        // StringBuilder which stores the serialized Binary Tree
        StringBuilder serialized = new StringBuilder();
        // Call the preorder traversal to serialize the B.T
        preorder(root, serialized);
        // Return the result as a string
        return serialized.toString();
    }
    // Function to build the binary tree from the string (Deserialize)
    public TreeNode buildBinaryTree(Deque<String> serialized) {
        // Get the front element
        String data = serialized.poll();
        // If it equals # i.e null then return null
        if (data.equals("#")) {
            return null;
        }
        // Create the node for this data by converting string to data
        TreeNode node = new TreeNode(Integer.parseInt(data));
        // Recursively go left
        node.left = buildBinaryTree(serialized);
        // Recursively go right
        node.right = buildBinaryTree(serialized);
        // Return node
        return node;
    }
    // Function which decodes encoded data to binary tree.
    public TreeNode deserialize(String data) {
        // Create a dequeue of Strings by splitting the string by the delimiter ',' and getting a ArrayList
        Deque<String> serialized = new ArrayDeque<>(Arrays.asList(data.split(",")));
        // Build the binary tree using this Deque and return it's root
        return buildBinaryTree(serialized);
    }
}

// T.C => O(N) for both serialize and deserialize functions
// S.C => O(N) for both serialize and deserialize functions
