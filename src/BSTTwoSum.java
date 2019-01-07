import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 *
 * Given a Binary Search Tree and a target number, return true if there exist
 * two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 * Example 2:
 * Input:
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * Output: False
 */
public class BSTTwoSum {

    public boolean findTarget(TreeNode root, int k) {
        if(root == null)
            return false;
        Set<Integer> elementSet = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if(elementSet.contains(k - temp.val))
                return true;
            elementSet.add(temp.val);
            if(temp.left != null)
                q.offer(temp.left);
            if(temp.right != null)
                q.offer(temp.right);
        }
        return false;
    }

}
