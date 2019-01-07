import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/same-tree/
 *
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Example 1:
 * Input:     1         1
 * / \       / \
 * 2   3     2   3
 *
 * [1,2,3],   [1,2,3]
 * Output: true
 *
 * Example 2:
 * Input:     1         1
 * /           \
 * 2             2
 * [1,2],     [1,null,2]
 *
 * Output: false
 * Example 3:
 *
 * Input:     1         1
 * / \       / \
 * 2   1     1   2
 * [1,2,1],   [1,1,2]
 * Output: false
 */
public class IsSameTree {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(2);
        treeNode1.right = new TreeNode(3);
        treeNode1.left.left = new TreeNode(4);
        treeNode1.left.right = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(2);
        treeNode2.right = new TreeNode(3);
        treeNode2.left.left = new TreeNode(4);
        treeNode2.left.right = new TreeNode(5);
        IsSameTree isSameTree = new IsSameTree();
        boolean isSame = isSameTree.isSameTree(treeNode1, treeNode2);
        System.out.print(isSame);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.add(p);
        Queue<TreeNode> q2 = new LinkedList<>();
        q2.add(q);
        TreeNode t1, t2;
        while(!q1.isEmpty() && !q2.isEmpty()) {
            t1 = q1.poll();
            t2 = q2.poll();
            if(t1.val != t2.val)
                return false;
            if((t1.left != null && t2.left == null) || (t1.left == null && t2.left != null))
                return false;
            if((t1.right != null && t2.right == null) || (t1.right == null && t2.right != null))
                return false;
            if(t1.left != null )
                q1.add(t1.left);
            if(t1.right != null)
                q1.add(t1.right);
            if(t2.left != null)
                q2.add(t2.left);
            if(t2.right != null)
                q2.add(t2.right);
        }
        return q1.size() == q2.size();
    }
}
