/**
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *  2     7
 * / \   / \
 * 1   3 6   9
 * Output:
 *
 *     4
 *   /   \
 *  7     2
 * / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by following tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a
 * whiteboard so fuck off.
 */
public class CreateMirror {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        CreateMirror createMirror = new CreateMirror();
        TreeNode mirroredTreeNode = createMirror.createMirror(treeNode);
        System.out.print("Mirroring done");
    }

    public TreeNode createMirror(TreeNode root) {
        TreeNode temp;
        if (root != null) {
            createMirror(root.left);
            createMirror(root.right);
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }

}
