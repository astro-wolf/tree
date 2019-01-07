
import java.util.LinkedList;
import java.util.Queue;

/**
 * Write program for deleting a node from tree.
 *
 * -> Find the node to be deleted
 * -> Find the deepest node in tree
 * -> Replace deepest node with the node found
 * -> Delete deepest node
 */
//TODO
public class DeleteNode {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        DeleteNode deleteNode = new DeleteNode();
        deleteNode.deleteNode(treeNode, 2);
    }

    public boolean deleteNode(TreeNode root, int dataToDelete) {
        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.offer(root);
        TreeNode dataNode =  null, currentNode = null;
        while(!nodeQ.isEmpty()) {
            currentNode = nodeQ.poll();
            if(currentNode.val == dataToDelete)
                dataNode = currentNode;
            if(currentNode.left != null)
                nodeQ.offer(currentNode.left);
            if(currentNode.right != null)
                nodeQ.offer(currentNode.right);
        }
        if(dataNode == null)
            return false;
        else {
            dataNode = currentNode;
            currentNode = null;
            return true;
        }
    }

}
