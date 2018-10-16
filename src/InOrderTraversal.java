import java.util.Stack;

/**
 * Left - Root - Right
 * -> create an empty stack
 * -> initialize currentNode with root
 * -> run following while currentNode is not null OR stack is not empty
 * -> if currentNode is not null, then push current node onto stack, and set current node to current node's left
 * -> if currentNode is null, pop a node from stack, print it's value, and set current node to right of current node
 */
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
