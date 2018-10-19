import java.util.LinkedList;
import java.util.Queue;

/**
 * Write a program to find the sum of all nodes in a binary tree
 */
public class AddTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        AddTree addTree = new AddTree();
        int sum = addTree.addBtIterative(treeNode);
        System.out.print(sum);
    }

    public int addBtRecursive(TreeNode root) {
        if(root == null)
            return 0;
        else
            return root.val + addBtRecursive(root.left) + addBtRecursive(root.right);
    }

    public int addBtIterative(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.offer(root);
        int sum = 0;
        while(!nodeQ.isEmpty()) {
            TreeNode currentNode = nodeQ.poll();
            sum += currentNode.val;
            if(currentNode.left != null)
                nodeQ.offer(currentNode.left);
            if(currentNode.right != null)
                nodeQ.offer(currentNode.right);
        }
        return sum;
    }

}
