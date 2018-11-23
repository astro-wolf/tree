import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *      3
 *     / \
 *    9  20
 *   /    \
 * 15      7
 * return its minimum depth = 2.
 */
public class FindMinHeight {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        FindMinHeight findMinHeight = new FindMinHeight();
        int count = findMinHeight.minHeight(treeNode);
        System.out.print(count);
    }

    public int minHeight(TreeNode root) {
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
                if (currentNode.left == null && currentNode.right == null)
                    return count;
                if (currentNode.left != null)
                    nodeQ.offer(currentNode.left);
                if (currentNode.right != null)
                    nodeQ.offer(currentNode.right);
            } else {
                if (!nodeQ.isEmpty()) {
                    count++;
                    nodeQ.offer(null);
                }
            }
        }
        return count;
    }

}
