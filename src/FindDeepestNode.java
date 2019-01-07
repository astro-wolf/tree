import java.util.LinkedList;
import java.util.Queue;

/**
 * Write an algo to find deepest node in a tree
 *
 * Algo:
 * The last node in a queue, used for level order traversal, will be the deepest node in tree.
 */
public class FindDeepestNode {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        FindDeepestNode findDeepestNode = new FindDeepestNode();
        TreeNode deepest = findDeepestNode.deepestNode(treeNode);
        System.out.print(deepest);
    }

    public TreeNode deepestNode(TreeNode root) {
        if(root == null)
            return root;
        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.offer(root);
        TreeNode currentNode = root;
        while(!nodeQ.isEmpty()) {
            currentNode = nodeQ.poll();
            if(currentNode.left != null)
                nodeQ.offer(currentNode.left);
            if(currentNode.right != null)
                nodeQ.offer(currentNode.right);
        }
        return currentNode;
    }

}
