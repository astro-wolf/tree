import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Write a program to implement zigzag traversal of tree. In zigzag traversal, first level is traversed left-to-right,
 * then next level is traversed right-to-left, and thus inverting each time we move to next level.
 *
 * Which order goes first and which after that, can be decided with leftToRight variable in below program
 */
public class ZigZagTraversal {

    public static void main(String[] a) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        ZigZagTraversal zigZagTraversal = new ZigZagTraversal();
        ArrayList<ArrayList<Integer>> res = zigZagTraversal.zigZagLevelOrder(treeNode);
        System.out.println(res);
    }

    public ArrayList<ArrayList<Integer>> zigZagLevelOrder(TreeNode treeNode) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(treeNode == null)
            return res;
        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.offer(treeNode);
        nodeQ.offer(null);
        boolean leftToRight = false;
        ArrayList<Integer> curr = new ArrayList<>();
        while(!nodeQ.isEmpty()) {
            TreeNode tmp = nodeQ.poll();
            if(tmp != null) {
                curr.add(tmp.val);
                if(tmp.left != null)
                    nodeQ.offer(tmp.left);
                if(tmp.right != null)
                    nodeQ.offer(tmp.right);
            } else {
                if(leftToRight) {
                    ArrayList<Integer> curr_c = new ArrayList<>(curr);
                    res.add(curr_c);
                    curr.clear();
                } else {
                    ArrayList<Integer> curr_c = new ArrayList<>();
                    Stack<Integer> currStack = new Stack<>();
                    currStack.addAll(curr);
                    while (!currStack.isEmpty())
                        curr_c.add(currStack.pop());
                    curr.clear();
                    res.add(curr_c);
                }
                if(!nodeQ.isEmpty()) {
                    nodeQ.offer(null);
                    leftToRight = !leftToRight;
                }
            }
        }
        return res;
    }

}
