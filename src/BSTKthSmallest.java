/**
 * Find the kth smallest element in a given binary search tree
 */
public class BSTKthSmallest {

    public static void main(String[] a) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        TreeNode rightRoot = new TreeNode(8);
        root.right = rightRoot;
        rightRoot.left = new TreeNode(5);
        rightRoot.right = new TreeNode(9);
        rightRoot.left = new TreeNode(5);
        rightRoot.left.right = new TreeNode(7);
        rightRoot.left.right.left = new TreeNode(6);
    }

}
