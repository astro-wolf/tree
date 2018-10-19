/**
 * Write a program to create a mirror of a tree
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
        if(root != null) {
            createMirror(root.left);
            createMirror(root.right);
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }

}
