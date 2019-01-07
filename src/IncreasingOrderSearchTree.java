import java.util.Stack;

/**
 * https://leetcode.com/problems/increasing-order-search-tree/description/
 *
 * Given a tree, rearrange the tree in in-order so that the leftmost node in
 * the tree is now the root of the tree, and every node has no left child and
 * only 1 right child.
 *
 * Example 1:
 * Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 * 5
 * / \
 * 3    6
 * / \    \
 * 2   4    8
 * /        / \
 * 1        7   9
 *
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * \
 * 7
 * \
 * 8
 * \
 * 9
 * Note:
 *
 * The number of nodes in the given tree will be between 1 and 100.
 * Each node will have a unique integer value from 0 to 1000.
 */
public class IncreasingOrderSearchTree {

    public static void main(String[] a) {
        TreeNode treeNode = new TreeNode(5);
//        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(6);
//        treeNode.left.left = new TreeNode(2);
//        treeNode.left.right = new TreeNode(4);
//        treeNode.left.left.left = new TreeNode(1);
//        treeNode.right.right = new TreeNode(8);
//        treeNode.right.right.left = new TreeNode(7);
//        treeNode.right.right.right = new TreeNode(9);
        IncreasingOrderSearchTree increasingOrderSearchTree = new IncreasingOrderSearchTree();
        TreeNode res = increasingOrderSearchTree.increasingBST(treeNode);
    }

    public TreeNode increasingBST(TreeNode root) {
        if (root == null)
            return root;
        TreeNode newRoot = null;
        TreeNode currentNode = root;
        TreeNode intNode = null;
        Stack<TreeNode> nodeStack = new Stack<>();
        while (!nodeStack.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                nodeStack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode temp = nodeStack.pop();
                TreeNode newRight = new TreeNode(temp.val);
                if (newRoot == null) {
                    newRoot = newRight;
                } else if (newRoot.right == null) {
                    newRoot.right = newRight;
                    intNode = newRight;
                } else {
                    intNode.right = newRight;
                    intNode = intNode.right;
                }
                currentNode = temp.right;
            }
        }
        return newRoot;
    }

}
