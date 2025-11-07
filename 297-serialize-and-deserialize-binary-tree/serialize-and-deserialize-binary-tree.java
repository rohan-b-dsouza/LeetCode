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
    public void preorder(TreeNode root, StringBuilder serialized) {
        if (root == null) {
            serialized.append('#').append(',');
            return;
        }
        serialized.append(root.val).append(',');
        preorder(root.left, serialized);
        preorder(root.right, serialized);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder serialized = new StringBuilder();
        preorder(root, serialized);
        return serialized.toString();
    }
    public TreeNode buildBinaryTree(Deque<String> serialized) {
        String data = serialized.poll();
        if (data.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(data));
        node.left = buildBinaryTree(serialized);
        node.right = buildBinaryTree(serialized);
        return node;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> serialized = new ArrayDeque<>(Arrays.asList(data.split(",")));
        return buildBinaryTree(serialized);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));