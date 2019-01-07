import java.util.Stack;

/**
 * Left - Right - Root
 * -> create an empty stack, and initialize currentNode with root
 * -> while currentNode is not null OR stack is not empty, run the following loop
 * -> if currentNode is not null, then push right of current node to stack, and then push current node to stack
 * -> set currentNode = currentNode.left
 * -> if currentNode is null, pop an element from stack, put it into currentNode
 * -> check if popped element's right is equal to top of stack. If it is, then pop the top of stack, push the currentNode
 *    onto stack, and put the popped item in current node.
 * -> if any of  the above conditions fail, just print the value in current node, and set currentNode to null
 */
public class PostOrderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
        postOrderTraversal.postOrderTraversal(treeNode);
    }

    public void postOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stackNode = new Stack<>();
        TreeNode currentNode = root;
        while (currentNode != null || !stackNode.isEmpty()) {
            if (currentNode != null) {
                if (currentNode.right != null)
                    stackNode.push(currentNode.right);
                stackNode.push(currentNode);
                currentNode = currentNode.left;
            } else {
                currentNode = stackNode.pop();
                if (!stackNode.isEmpty() && currentNode.right != null && stackNode.peek() == currentNode.right) {
                    TreeNode tempNode = stackNode.pop();
                    stackNode.push(currentNode);
                    currentNode = tempNode;
                } else {
                    System.out.print(currentNode.val + "\n");
                    currentNode = null;
                }
            }
        }
    }

}
