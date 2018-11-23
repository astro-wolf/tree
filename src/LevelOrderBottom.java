import java.util.*;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right,
 * level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class LevelOrderBottom {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        LevelOrderBottom levelOrderBottom = new LevelOrderBottom();
        levelOrderBottom.levelOrderBottom(treeNode);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Stack<List<Integer>> resStack = new Stack<>();
        Queue<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.offer(root);
        nodeQ.offer(null);
        List<Integer> curr = new ArrayList<>();
        while(!nodeQ.isEmpty()) {
            TreeNode tempNode = nodeQ.poll();
            if(tempNode != null) {
                curr.add(tempNode.val);
                if(tempNode.left != null)
                    nodeQ.offer(tempNode.left);
                if(tempNode.right != null)
                    nodeQ.offer(tempNode.right);
            } else {
                List<Integer> curr_c = new ArrayList<>(curr);
                resStack.add(curr_c);
                curr.clear();
                if(!nodeQ.isEmpty())
                    nodeQ.offer(null);
            }
        }
        while(!resStack.isEmpty())
            res.add(resStack.pop());
        return res;
    }

}
