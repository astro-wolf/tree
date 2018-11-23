/**
 * Find the lowest common ancestor for two given nodes
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode lca = lowestCommonAncestor.lowestCommonAncestor(treeNode, treeNode.left.left, treeNode.left.right);
        System.out.println(lca);
    }

    public TreeNode LCA(TreeNode root, TreeNode a, TreeNode b) {

        //base case
        if (root == null)
            return null;

        //if any of the nodes are equal to root, return root
        //if any given node is equal to root, it becomes ancestor to other
        if (root == a || root == b)
            return root;

        TreeNode left = LCA(root.left, a, b);
        TreeNode right = LCA(root.right, a, b);

        //if both above calls return non-null nodes
        //it means this node is lowest common ancestor possible
        if (left != null && right != null)
            return root;

        //otherwise, check if left or right subtree is LCA
        return left != null ? left : right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while((root.val - p.val) * (root.val - q.val) > 0)
            root = p.val < root.val ? root.left : root.right;
        return root;
    }

}
