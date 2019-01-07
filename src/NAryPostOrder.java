import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 */
public class NAryPostOrder {

    public List<Integer> postorder(Node root) {
        return postOrder(root, new ArrayList<>());
    }

    private List<Integer> postOrder(Node root, List<Integer> res) {
        if (root == null)
            return res;
        if (root.children != null && !root.children.isEmpty())
            for (Node node : root.children) {
                postOrder(node, res);
            }
        res.add(root.val);
        return res;
    }

}
