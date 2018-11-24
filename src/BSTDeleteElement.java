/**
 * Implement a program to delete an element from a binary search tree
 */
public class BSTDeleteElement {

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
        BSTDeleteElement bstDeleteElement = new BSTDeleteElement();
        TreeNode res = bstDeleteElement.remove(root, 8);
        System.out.println(res);
    }

    /**
     * Remove an element from BST
     * This essentially updates the whole tree, since assignment is done at every stage or recursion, and when the
     * elements are being removed as well
     *
     * @param root root node
     * @param data value to remove
     * @return root node
     */
    public TreeNode remove(TreeNode root, int data) {
        if(root == null)
            System.out.println("Given node not present in the tree");
        else if (data < root.val)
            root.left = remove(root.left, data);
        else if (data > root.val)
            root.right = remove(root.right, data);
        else {
            //element found
            if(root.left != null && root.right != null) {
                //both nodes present
                //find greatest node from left subtree
                // or we can find smallest node from right subtree as well
                TreeNode temp = BSTFindMaxMin.findMax(root.left);
                root.val = temp.val;
                root.left = remove(root.left, root.val);
            } else {
                //only one node present
                TreeNode temp = root;
                if(root.left == null)
                    root = root.right;
                else
                    root = root.left;
                temp = null;
            }
        }
        return root;
    }

}
