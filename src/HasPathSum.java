/**
 * Given a sum, find if path from root to node exist, which gives the sum
 */
public class HasPathSum {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        HasPathSum hasPathSum = new HasPathSum();
        boolean hasPath = hasPathSum.hasPathSum(treeNode, 3);
        System.out.print(hasPath);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        //if the requirement is to find the leaf, then we can add left and right null check here
        if(root.val == sum && root.left == null && root.right == null)
            return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
