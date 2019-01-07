import java.util.Stack;

/**
 * Root - Left - Right
 * -> create a stack, and push root onto it
 * -> run following while stack is not empty
 * -> pop a node, print its value
 * -> add node's right to stack
 * -> add node's left to stack
 */
public class PreOrderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
        preOrderTraversal.preOrderTraversal(treeNode);
    }

    public void preOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stackNode = new Stack<>();
        stackNode.push(root);
        TreeNode tempNode;
        while (!stackNode.isEmpty()) {
            tempNode = stackNode.pop();
            System.out.print(tempNode.val + "\n");
            if (tempNode.right != null)
                stackNode.push(tempNode.right);
            if (tempNode.left != null)
                stackNode.push(tempNode.left);
        }
    }

}
