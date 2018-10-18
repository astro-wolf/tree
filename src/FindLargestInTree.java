import jdk.nashorn.api.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Write an algorithm to find node in tree, with maximum value
 */
public class FindLargestInTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        FindLargestInTree findLargestInTree = new FindLargestInTree();
        int max = findLargestInTree.maxBinaryTreeWithLevelOrder(treeNode);
        System.out.print(max);
    }

    public int maxBinaryTreeWithLevelOrder(TreeNode root){
        int result = Integer.MIN_VALUE;
        Queue<TreeNode> stackNode = new LinkedList<>();
        stackNode.add(root);
        TreeNode currentNode;
        while (!stackNode.isEmpty()) {
            currentNode = stackNode.poll();
            result = Math.max(currentNode.val, result);
            if(currentNode.left != null)
                stackNode.add(currentNode.left);
            if(currentNode.right != null)
                stackNode.add(currentNode.right);
        }
        return result;
    }

    public int maxBinaryTree(TreeNode root) {
        int result = Integer.MIN_VALUE;
        if (root != null) {
            int leftMax = maxBinaryTree(root.left);
            int rightMax = maxBinaryTree(root.right);
            result = Math.max(leftMax, rightMax);
            result = Math.max(root.val, result);
        }
        return result;
    }

}
