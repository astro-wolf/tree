import java.util.LinkedList;
import java.util.Queue;

/**
 * Write a program for inserting an item in a BinaryTree
 */
public class InsertInTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        InsertInTree insertInTree = new InsertInTree();
        /*TreeNode root = */
        insertInTree.insertRecursive(treeNode, 6);
        System.out.print("Inserted");
    }

    public void insertRecursive(TreeNode root, int data) {
        if (root == null)
            root = new TreeNode(data);
        else
            insertHelper(root, data);
    }

    public void insertHelper(TreeNode root, int data) {
        if (root.val <= data) {
            if (root.left == null)
                root.left = new TreeNode(data);
            else
                insertHelper(root.left, data);
        } else {
            if (root.right == null)
                root.right = new TreeNode(data);
            else
                insertHelper(root.right, data);
        }
    }

    public TreeNode insertInBinaryTreeLevelOrder(TreeNode root, int data) {
        if (root == null)
            return new TreeNode(data);
        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.offer(root);
        TreeNode currentNode;
        while (!nodeQ.isEmpty()) {
            currentNode = nodeQ.poll();
            if (currentNode.left != null)
                nodeQ.offer(currentNode.left);
            else {
                currentNode.left = new TreeNode(data);
                return root;
            }
            if (currentNode.right != null)
                nodeQ.offer(currentNode.right);
            else {
                currentNode.right = new TreeNode(data);
                return root;
            }
        }
        return root;
    }

}
