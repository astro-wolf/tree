import java.util.LinkedList;
import java.util.Queue;

/**
 * write a program to find maximum sum for a level
 */
public class MaxSumLevel {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        MaxSumLevel maxSumLevel = new MaxSumLevel();
        int maxSum = maxSumLevel.findLevelWithMaxSum(treeNode);
        System.out.print(maxSum);
    }

    public int findLevelWithMaxSum(TreeNode root) {
        if (root == null)
            return 0;
        int sum = 0, maxSum = 0;
        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.offer(root);
        nodeQ.offer(null);
        sum = root.val;
        TreeNode currentNode;
        while (!nodeQ.isEmpty()) {
            currentNode = nodeQ.poll();
            if (currentNode != null) {
                sum += currentNode.val;
                if (currentNode.left != null)
                    nodeQ.offer(currentNode.left);
                if (currentNode.right != null)
                    nodeQ.offer(currentNode.right);
            } else {
                maxSum = Math.max(sum, maxSum);
                sum = 0;
                if (!nodeQ.isEmpty())
                    nodeQ.offer(null);
            }
        }
        return maxSum;
    }

}
