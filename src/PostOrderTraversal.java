import java.util.Stack;

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
        if(root == null)
            return;
        Stack<TreeNode> stackNode = new Stack<>();
        TreeNode currentNode = root;
        while(currentNode != null || !stackNode.isEmpty()) {
            if(currentNode != null) {
                if(currentNode.right != null)
                    stackNode.push(currentNode.right);
                stackNode.push(currentNode);
                currentNode = currentNode.left;
            } else {
                currentNode = stackNode.pop();
                if(!stackNode.isEmpty() && currentNode.right != null && stackNode.peek() == currentNode.right) {
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
