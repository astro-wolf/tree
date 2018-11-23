import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Practice {

    public static void main(String[] a) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
//        treeNode.left.left = new TreeNode(4);
//        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        Practice practice = new Practice();
        int res = practice.minDepth(treeNode);
        System.out.println(res);
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int count = 1;
        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.offer(root);
        nodeQ.offer(null);
        while (!nodeQ.isEmpty()) {
            TreeNode tempNode = nodeQ.poll();
            if (tempNode != null) {
                if (tempNode.left == null && tempNode.right == null) {
                    return count;
                }
                if (tempNode.left != null) {
                    nodeQ.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    nodeQ.offer(tempNode.right);
                }
            } else {
                if (!nodeQ.isEmpty()) {
                    count++;
                    nodeQ.offer(null);
                }
            }
        }
        return count;
    }

    private boolean hasPathSum(TreeNode root, int sum) {
        return root != null
                && ((root.val == sum)
                || hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val));
    }

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.right);
            invertTree(root.left);
        }
        return root;
    }

}
