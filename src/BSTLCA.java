/**
 * Find the least common ancestor in a binary search tree
 */
public class BSTLCA {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        TreeNode rightRoot = new TreeNode(8);
        root.right = rightRoot;
        rightRoot.left = new TreeNode(5);
        rightRoot.right = new TreeNode(9);
        rightRoot.left = new TreeNode(5);
        rightRoot.left.right = new TreeNode(7);
        rightRoot.left.right.left = new TreeNode(6);
        BSTLCA bstlca = new BSTLCA();
        TreeNode res = bstlca.LCA(root, 9, 6);
        System.out.println(res);
    }

    public TreeNode LCA(TreeNode root, int a, int b) {
        if (root == null)
            return root;
        if (root.val == a || root.val == b)
            return root;
        if (Math.min(a, b) > root.val)
            return LCA(root.right, a, b);
        else if (Math.max(a, b) < root.val)
            return LCA(root.left, a, b);
        return root;
    }

}
