/**
 * Write a program to insert an element into binary search tree
 */
public class BSTInsertElement {

    /**
     * Inserts a new node into BST and returns the root node in the end.
     *
     * This method essentially updates the whole tree again, since assignments are done at every step of recursion
     *
     * @param root root node
     * @param data value to insert
     * @return root node
     */
    public TreeNode insert(TreeNode root,  int data) {
        if(root == null) {
            root = new TreeNode(data);
        } else {
            if(data > root.val)
                root.right = insert(root.right, data);
            else
                root.left = insert(root.left, data);
        }
        return root;
    }

}
