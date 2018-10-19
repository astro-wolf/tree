/**
 * Write a program to find diameter of a tree
 */
public class DiameterOfTree {

    int diameter = 0;

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        DiameterOfTree diameterOfTree = new DiameterOfTree();
        int diameter = diameterOfTree.diameterOfTree(treeNode);
        System.out.print(diameter);
    }

    public int diameterOfTree(TreeNode root) {
        if(root == null)
            return 0;
        int left, right;
        left = diameterOfTree(root.left);
        right = diameterOfTree(root.right);
        if(left + right > diameter)
            diameter = left + right;
        return Math.max(left, right) + 1;
    }

}
