import java.util.HashMap;

/**
 * Q: Write a program to find vertical sum of a tree
 * S: Take a hashmap. Key will be column, and value will be value for each column
 * if column already exists, update the value by adding the previous one in current node's data
 * We parse the tree using post order traversal
 */
public class VerticalSum {

    public static void main(String[] a) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        VerticalSum verticalSum = new VerticalSum();
        verticalSum.verticalSum(treeNode);
    }

    public void verticalSum(TreeNode root) {
        if(root == null)
            return;
        HashMap<Integer, Integer> columnMap = new HashMap<>();
        verticalSum(columnMap, root, 0);
        for(int k : columnMap.keySet()) {
            System.out.println("For column " + k + " sum is " + columnMap.get(k));
        }
    }

    public void verticalSum(HashMap<Integer, Integer> columnMap, TreeNode node, int column) {
        if(node.left != null)
            verticalSum(columnMap, node.left, column - 1);
        if(node.right != null)
            verticalSum(columnMap, node.right, column + 1);
        int data = columnMap.getOrDefault(column, 0);
        columnMap.put(column, node.val + data);
    }

}
