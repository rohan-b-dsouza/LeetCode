// Brute-Force Approach (Though this fails for larger value of numRows due to integer overflow while calculating factorial, as factorials grow quickly)

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