import java.util.LinkedList;
import java.util.Queue;

/**
 * Write a program to find minimum height  of tree
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
        while(!nodeQ.isEmpty()) {
            currentNode = nodeQ.poll();
            if(currentNode != null) {
                if(currentNode.left == null && currentNode.right == null)
                    return count;
                if(currentNode.left != null)
                    nodeQ.offer(currentNode.left);
                if(currentNode.right != null)
                    nodeQ.offer(currentNode.right);
            } else {
                if(!nodeQ.isEmpty()) {
                    count++;
                    nodeQ.offer(null);
                }
            }
        }
        return count;
    }

}
