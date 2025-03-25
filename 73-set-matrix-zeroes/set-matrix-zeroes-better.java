// Better-Solution (Using 2 HashSets)

class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet <Integer> row = new HashSet<>();
        HashSet <Integer> col = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(row.contains(i)) matrix[i][j] = 0;
                else if(col.contains(j)) matrix[i][j] = 0;
            }
        }
    }
}

// T.C => O(n*m) + O(n*m) = O(2(n*m)) = O(n*m)
// S.C => O(n + m) 
