// Variety 1: Given row number r and column number c. Print the 
// element at position (r, c) in Pascal’s triangle.

// Optimal Approach =>

class Solution {

    public long Pascal(int row, int col) {
        int i = row - 1;
        int r = col - 1;
        long curr = 1;
        for (int j = 0; j < r; j++) {
            curr = (curr * (i - j)) / (j + 1);
        }
        return curr;
    }
}
        
 

public class Variety1Optimal {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        System.out.println(s1.Pascal(4, 2));
    }
}

// T.C => O(r)
// S.C => O(1)
