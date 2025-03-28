// Given the row number n. Print the n-th row of Pascal’s triangle.

// Brute - Force Solution =>

class Solution3 {
    public long generate(int n, int r) {
        long curr = 1;
        for (int j = 0; j < r; j++) {
            curr = (curr * (n - j)) / (j + 1);
        }
        return curr;
    }
    public void Pascal(int n) {
        for (int c = 1; c <= n; c++) {
            System.out.print((generate(n - 1, c - 1)) + " ");
        }
        
    }
}
public class Variety2Brute {
    public static void main(String[] args) {
        Solution3 s1 = new Solution3();
        s1.Pascal(4);
    }
}

// T.C => O(n*r)
// S.C => O(1)
