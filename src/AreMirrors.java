/**
 * Write a program to find if two trees are mirror of each other
 */
public class AreMirrors {

    public static void main(String[] a) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(3);
        treeNode2.right = new TreeNode(2);
        AreMirrors areMirrors = new AreMirrors();
        boolean isMirror = areMirrors.areMirrors(treeNode1, treeNode2);
        System.out.print(isMirror);
    }

    //to find if one tree is symmetric
    public boolean findMirrors(TreeNode root) {
        return areMirrors(root.left, root.right);
    }

    public boolean areMirrors(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        if(root1.val != root2.val)
            return false;
        return areMirrors(root1.left, root2.right) && areMirrors(root1.right, root2.left);
    }

}
