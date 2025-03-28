// Variety 1: Given row number r and column number c. Print the 
// element at position (r, c) in Pascal’s triangle.

// Brute-Force Solution =>
// This solution is very inefficient and causes integer and even long overflow 
// for large values of n as factorial grows quickly.

class Solution {
    public int fact(int x) {
        int fact = 1;
        for (int i = 2; i <= x; i++) {
            fact = fact * i;
        }
        return fact;
    }
    public int Pascal(int row, int col) {
        int n = row - 1;
        int r = col - 1;
        int ncr = fact(n) / (fact(r) * fact(n - r));
        return ncr;
    }
}

public class Variety1brute {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1.Pascal(4, 2));
    }
}

// T.C =>  O(n) + O(r) + O(n - r) => O(n)
// S.C => O(1) 
