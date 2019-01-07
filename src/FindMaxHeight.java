import java.util.LinkedList;
import java.util.Queue;

/**
 * Write a program for finding the max height of tree
 */
public class FindMaxHeight {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        FindMaxHeight findMaxHeight = new FindMaxHeight();
        int maxHeight = findMaxHeight.maxDepthIterative(treeNode);
        System.out.print(maxHeight);
    }

    public int maxDepthIterative(TreeNode root) {
        if (root == null)
            return 0;
        int count = 1;
        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.offer(root);
        nodeQ.offer(null);
        TreeNode currentNode;
        while (!nodeQ.isEmpty()) {
            currentNode = nodeQ.poll();
            if (currentNode != null) {
                if (currentNode.left != null)
                    nodeQ.offer(currentNode.left);
                if (currentNode.right != null)
                    nodeQ.offer(currentNode.right);
            } else {
                if (!nodeQ.isEmpty()) {
                    nodeQ.offer(null);
                    count++;
                }
            }
        }
        return count;
    }

    public int maxDepthRecursive(TreeNode root) {
        if (root == null)
            return 0;
        int leftCount = maxDepthRecursive(root.left);
        int rightCount = maxDepthRecursive(root.right);
        return 1 + Math.max(leftCount, rightCount);
    }

}
