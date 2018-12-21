import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 *
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 *
 * Example 1:
 * Input:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 *
 * Note:
 * The range of node's value is in the range of 32-bit signed integer
 */
public class AverageOfLevels {

    public static void main(String[] a) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode rightRoot = new TreeNode(20);
        root.right = rightRoot;
        rightRoot.left = new TreeNode(15);
        rightRoot.right = new TreeNode(7);
        AverageOfLevels averageOfLevels = new AverageOfLevels();
        List<Double> res = averageOfLevels.averageOfLevels(root);
        System.out.println(res);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        double sum = 0;
        int count = 0;
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            if(temp != null) {
                sum += temp.val;
                count++;
                if(temp.left != null)
                    q.offer(temp.left);
                if(temp.right != null)
                    q.offer(temp.right);
            } else {
                if(!q.isEmpty())
                    q.offer(null);
                res.add(sum / count);
                sum = 0;
                count = 0;
            }
        }
        return res;
    }

}
