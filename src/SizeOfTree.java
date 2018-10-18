import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement a program to find the size of tree
 */
public class SizeOfTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        SizeOfTree sizeOfTree = new SizeOfTree();
        int size = sizeOfTree.sizeIterative(treeNode);
        System.out.print(size);
    }

    public int sizeIterative(TreeNode root) {
        if(root == null)
            return 0;
        int size = 0;
        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.offer(root);
        TreeNode currentNode;
        while(!nodeQ.isEmpty()) {
            currentNode = nodeQ.poll();
            size++;
            if(currentNode.left != null)
                nodeQ.offer(currentNode.left);
            if(currentNode.right != null)
                nodeQ.offer(currentNode.right);
        }
        return size;
    }

    public int size(TreeNode root) {
        int leftCount = root.left == null ? 0 : size(root.left);
        int rightCount = root.right == null ? 0 : size(root.right);
        return 1 + leftCount + rightCount;
    }

}
