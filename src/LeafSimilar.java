/**
 * https://leetcode.com/problems/leaf-similar-trees/description/
 *
 * Consider all the leaves of a binary tree.  From left to right order, the values of
 * those leaves form a leaf value sequence.
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 * Note:
 * Both of the given trees will have between 1 and 100 nodes.
 */
public class LeafSimilar {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return traverse(root1).equals(traverse(root2));
    }

    private String traverse(TreeNode root) {
        if (root == null) return "";
        if (root.left == null && root.right == null) return root.val + "-";
        return traverse(root.left) + traverse(root.right);
    }
}
