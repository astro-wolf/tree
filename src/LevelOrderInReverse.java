import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Write a program to print output from level order traversal in reverse
 */
public class LevelOrderInReverse {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        LevelOrderInReverse levelOrderInReverse = new LevelOrderInReverse();
        levelOrderInReverse.leverOrderTraversalInReverse(treeNode);
    }

    public void leverOrderTraversalInReverse(TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> nodeStack = new Stack<>();
        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.offer(root);
        TreeNode currentNode;
        while(!nodeQ.isEmpty()) {
            currentNode = nodeQ.poll();
            nodeStack.add(currentNode);
            if(currentNode.left != null)
                nodeQ.offer(currentNode.left);
            if(currentNode.right != null)
                nodeQ.offer(currentNode.right);
        }
        while(!nodeStack.isEmpty())
            System.out.print(nodeStack.pop().val + "\n");
    }

}
