/**
 * Given a binary tree, print all its root-to-leaf paths
 */
public class PrintPaths {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        PrintPaths printPaths = new PrintPaths();
        printPaths.printPaths(treeNode);
    }

    public void printPaths(TreeNode root) {
        int[] path = new int[256];
        printPaths(root, path, 0);
    }

    public void printPaths(TreeNode root, int[] path, int pathLen) {
        if(root == null)
            return;
        path[pathLen] = root.val;
        pathLen++;
        if(root.left == null && root.right == null) {
            printPaths(path, pathLen);
        } else {
            printPaths(root.left, path, pathLen);
            printPaths(root.right, path, pathLen);
        }
    }

    public void printPaths(int[] path, int len) {
        for(int i = 0; i < len; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println();
    }

}
