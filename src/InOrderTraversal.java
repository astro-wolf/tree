import java.util.Stack;

public class InOrderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        inOrderTraversal.inOrderTraversal(treeNode);
    }

    public void inOrderTraversal(TreeNode treeNode) {
        if (treeNode == null)
            return;
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode currentNode = treeNode;
        while (currentNode != null || !nodeStack.isEmpty()) {
            if (currentNode != null) {
                nodeStack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode poppedNode = nodeStack.pop();
                System.out.print(poppedNode.val + "\n");
                currentNode = poppedNode.right;
            }
        }
    }

}
