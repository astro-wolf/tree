/**
 * Write a program to a BST from a sorted array
 */
public class BSTSortedArray {

    public static void main(String[] args) {
        BSTSortedArray bstSortedArray = new BSTSortedArray();
        int[] a = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode res = bstSortedArray.buildBST(a, 0, a.length - 1);
        System.out.println(res);
    }

    public TreeNode buildBST(int[] a, int left, int right) {
        TreeNode newNode;
        if (left > right)
            return null;
        if (left == right) {
            newNode = new TreeNode(a[left]);
            newNode.left = null;
            newNode.right = null;
        } else {
            int mid = left + (right - left) / 2;
            newNode = new TreeNode(a[mid]);
            newNode.left = buildBST(a, left, mid - 1);
            newNode.right = buildBST(a, mid + 1, right);
        }
        return newNode;
    }

}
