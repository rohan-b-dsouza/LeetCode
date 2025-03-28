// Optimal - Approach =>

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listoflists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List <Integer> sublist = new ArrayList<>();
            int curr = 1;
            for (int j = 0; j <= i; j++) {
                sublist.add(curr);
                curr = (curr* (i - j)) / (j + 1);
            }
            listoflists.add(sublist);
        }
        return listoflists;
    }
    
}

// T.C => O(n^2)
// S.C => O(1) as extra space is used for storing the ans not to solve it
