/**
 * Build a binary tree from preOrder and inOrder array
 */
public class BuildBinaryTree {

    public static void main(String[] args) {
        BuildBinaryTree buildBinaryTree = new BuildBinaryTree();
        TreeNode tree = buildBinaryTree.buildBinaryTree(new int[]{1, 2, 4, 3, 5, 6}, new int[]{4, 2, 5, 1, 6, 3});
        System.out.print(tree);
    }

    public TreeNode buildBinaryTree(int[] preOrder, int[] inOrder) {
        if (preOrder.length == 0 || preOrder.length != inOrder.length)
            return null;
        return buildBt(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    public TreeNode buildBt(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        int data = preOrder[preStart];
        TreeNode curr = new TreeNode(data);
        int offset = inStart;
        for (; offset < inEnd; offset++)
            if (inOrder[offset] == data)
                break;
        curr.left = buildBt(preOrder, preStart + 1, preStart + offset - inStart,
                inOrder, inStart, offset - 1);
        curr.right = buildBt(preOrder, preStart + offset - inStart + 1,
                preEnd, inOrder, offset + 1, inEnd);
        return curr;
    }

}
