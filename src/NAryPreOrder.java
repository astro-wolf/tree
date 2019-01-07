import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 */
public class NAryPreOrder {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(Node root, List<Integer> list) {
        if(root == null)
            return;
        list.add(root.val);
        for(Node node : root.children)
            preOrder(node, list);
    }

}
