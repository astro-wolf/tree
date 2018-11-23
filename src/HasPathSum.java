/**
 * https://leetcode.com/problems/path-sum/description/
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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
        if (root == null)
            return false;
        //if the requirement is to find the leaf, then we can add left and right null check here
        if (root.val == sum && root.left == null && root.right == null)
            return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
