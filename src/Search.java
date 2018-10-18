import java.util.LinkedList;
import java.util.Queue;

/**
 * Write a program to find an element in tree
 */
public class Search {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        Search search = new Search();
        boolean found = search.findInTreeLevelOrder(treeNode, 33);
        System.out.print(found);
    }

    public boolean findInTreeLevelOrder(TreeNode root, int data) {
        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.add(root);
        TreeNode currentNode;
        while (!nodeQ.isEmpty()) {
            currentNode = nodeQ.poll();
            if(currentNode.val == data)
                return true;
            if(currentNode.left != null)
                nodeQ.add(currentNode.left);
            if(currentNode.right != null)
                nodeQ.add(currentNode.right);
        }
        return false;
    }

    public boolean findInTree(TreeNode root, int data) {
        return root != null && (root.val == data || findInTree(root.left, data) || findInTree(root.right, data));
    }

}
