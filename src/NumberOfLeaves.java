import java.util.LinkedList;
import java.util.Queue;

/**
 * Write an program to find number of leaves in a tree
 */
public class NumberOfLeaves {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        NumberOfLeaves numberOfLeaves = new NumberOfLeaves();
        int leaves = numberOfLeaves.numberOfLeaves(treeNode);
        System.out.print(leaves);
    }

    public int numberOfLeaves (TreeNode root) {
        if(root == null)
            return 0;
        int count = 0;
        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.offer(root);
        TreeNode currentNode;
        while (!nodeQ.isEmpty()) {
            currentNode = nodeQ.poll();
            if(currentNode.left == null && currentNode.right == null)
                count++;
            if(currentNode.left != null)
                nodeQ.offer(currentNode.left);
            if(currentNode.right != null)
                nodeQ.offer(currentNode.right);
        }
        return count;
    }

}
