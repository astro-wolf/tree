/**
 * Given a number, find out how many trees can be made from that many nodes
 */
public class PossibleTrees {

    public static void main(String[] args) {
        PossibleTrees possibleTrees = new PossibleTrees();
        int possibilities = possibleTrees.numOfBST(3);
        System.out.println(possibilities);
    }

    public int numOfBST(int n) {
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                count[i] += count[j] * count[i - j - 1];
            }
        }
        return count[n];
    }

}
