/**
 * Find if a tree is binary search tree or not
 */
public class BSTValidate {

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
        BSTValidate bstValidate = new BSTValidate();
        boolean isValid = bstValidate.isBST(root);
        System.out.println(isValid);
    }

    public boolean isBST(TreeNode root) {
        if(root == null)
            return true;
        //if left node's data is greater than current node's, return false
        if(root.left != null && root.left.val > root.val)
            return false;
        //if right node's data is smaller than current node's, return false
        if(root.right != null && root.right.val < root.val)
            return false;
        //recursively check for right and left nodes as well
        if(!isBST(root.right) || !isBST(root.left))
            return false;
        //if all the upper checks pass, return true
        return true;
    }

}
