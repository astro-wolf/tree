import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 *
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 */
public class NAryLevelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        List<Integer> levelLists = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if(temp!= null) {
                levelLists.add(temp.val);
                if(!temp.children.isEmpty())
                    for(Node node : temp.children)
                        q.offer(node);
            } else {
                if(!q.isEmpty())
                    q.offer(null);
                res.add(levelLists);
                levelLists = new ArrayList<>();
            }
        }
        return res;
    }

}
