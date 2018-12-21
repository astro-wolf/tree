import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 *
 * Given a n-ary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class NAryMaxDepth {

    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        int res = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if(temp != null) {
                for(Node node : temp.children)
                    q.offer(node);
            } else {
                if(!q.isEmpty()) {
                    q.offer(null);
                }
                res++;
            }
        }
        return res;
    }
}
