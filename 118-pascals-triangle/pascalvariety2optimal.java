// Given the row number n. Print the n-th row of Pascal’s triangle.
// Optimal Solution =>

class Solution1 {
    public void Pascal(int n) {
        int i = n - 1;
        int curr = 1;
        for (int j = 0; j <= i; j++) {
            System.out.print(curr + " ");
            curr = (curr * (i - j)) / (j + 1);
        }
    }
}
public class Variety2Optimal {
    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        s1.Pascal(4);
    }
}
