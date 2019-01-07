/**
 * This class contains methods to return maximum element in a binary search tree and minimum element in a binary
 * search tree
 */
public class BSTFindMaxMin {

    /**
     * Returns minimum element in a binary search tree
     * @param root root node
     * @return node with smallest element
     */
    public static TreeNode findMin(TreeNode root) {
        while(root.left != null)
            root = root.left;
        return root;
    }

    /**
     * Returns maximum element in a binary search tree
     * @param root root node
     * @return node with greatest element
     */
    public static TreeNode findMax(TreeNode root) {
        while(root.right != null)
            root = root.right;
        return root;
    }
}
