import java.util.LinkedList;
import java.util.Queue;

/**
 * One level at a time
 * -> create a queue, and initialize it with root
 * -> repeat the following until queue is not empty
 * -> poll and element from queue, and print its value
 * -> put the left of element in queue, and then right of element in queue
 */
public class LevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        levelOrderTraversal.levelOrderTraversal(treeNode);
    }

    public void levelOrderTraversal(TreeNode root) {
        if(root == null)
            return;
        TreeNode currentNode = root;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(currentNode);
        while(!nodeQueue.isEmpty()) {
            currentNode = nodeQueue.poll();
            System.out.print(currentNode.val + "\n");
            if(currentNode.left != null)
                nodeQueue.add(currentNode.left);
            if(currentNode.right != null)
                nodeQueue.add(currentNode.right);
        }
    }

}
