/**
 * Find if a tree is binary search tree or not
 */
public class BSTValidate {

    private int prev = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        TreeNode rightRoot = new TreeNode(8);
        root.right = rightRoot;
        rightRoot.left = new TreeNode(5);
        rightRoot.right = new TreeNode(9);
        rightRoot.left.right = new TreeNode(7);
        rightRoot.left.right.left = new TreeNode(4);
        BSTValidate bstValidate = new BSTValidate();
        boolean isValid = bstValidate.isBST(root);
        System.out.println(isValid);
    }

    public boolean isBST(TreeNode root) {
        if(root == null)
            return true;
        if(!isBST(root.left))
            return false;
        if(root.val < prev)
            return false;
        prev = root.val;
        return isBST(root.right);
    }

}
