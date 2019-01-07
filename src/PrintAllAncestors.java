/**
 * Write a program to print ancestors of a node in a tree
 */
public class PrintAllAncestors {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        PrintAllAncestors printAllAncestors = new PrintAllAncestors();
        boolean hasAncestors = printAllAncestors.printAllAncestors(treeNode, new TreeNode(4));
        System.out.println(hasAncestors);
    }

    public boolean printAllAncestors(TreeNode root, TreeNode node) {
        if(root == null)
            return false;
        if(root.left == node || root.right == node
                || printAllAncestors(root.right, node) || printAllAncestors(root.left, node)) {
            System.out.println(root.val);
            return true;
        }
        return false;
    }

}
